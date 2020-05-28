package journal.workout.services;

import journal.workout.exceptions.CustomException;
import journal.workout.models.*;
import journal.workout.models.requests.*;
import journal.workout.models.responses.UserResponse;
import journal.workout.repositories.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class WJServiceImpl implements WJService {

    static ExercisesParametersRepository exercisesParametersRepository;
    static ExercisesRepository exercisesRepository;
    static ExerciseTypesRepository exerciseTypesRepository;
    static ParametersRepository parametersRepository;
    static ParameterResultsRepository parameterResultsRepository;
    static UsersRepository usersRepository;
    static DoneExerciseRepository userWorkoutParameterValuesRepository;
    static UserWorkoutsRepository userWorkoutsRepository;
    static WorkoutExercisesRepository workoutExercisesRepository;
    static WorkoutsRepository workoutsRepository;
    static DoneExerciseRepository doneExerciseRepository;

    public WJServiceImpl(ExercisesParametersRepository exercisesParametersRepository,
                         ExercisesRepository exercisesRepository,
                         ExerciseTypesRepository exerciseTypesRepository,
                         ParametersRepository parametersRepository,
                         ParameterResultsRepository parameterResultsRepository,
                         UsersRepository usersRepository,
                         DoneExerciseRepository userWorkoutParameterValuesRepository,
                         UserWorkoutsRepository userWorkoutsRepository,
                         WorkoutExercisesRepository workoutExercisesRepository,
                         WorkoutsRepository workoutsRepository,
                         DoneExerciseRepository doneExerciseRepository) {
        WJServiceImpl.exercisesParametersRepository = exercisesParametersRepository;
        WJServiceImpl.exercisesRepository = exercisesRepository;
        WJServiceImpl.exerciseTypesRepository = exerciseTypesRepository;
        WJServiceImpl.parametersRepository = parametersRepository;
        WJServiceImpl.parameterResultsRepository = parameterResultsRepository;
        WJServiceImpl.usersRepository = usersRepository;
        WJServiceImpl.userWorkoutParameterValuesRepository = userWorkoutParameterValuesRepository;
        WJServiceImpl.userWorkoutsRepository = userWorkoutsRepository;
        WJServiceImpl.workoutExercisesRepository = workoutExercisesRepository;
        WJServiceImpl.workoutsRepository = workoutsRepository;
        WJServiceImpl.doneExerciseRepository = doneExerciseRepository;
    }

    private User getUser() {
        var userCr = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return usersRepository.findByEmail(userCr.getUsername());
    }

    @Override
    public List<Workout> readWorkouts() {
        List<UserWorkout> userWorkouts = userWorkoutsRepository.getAllByUser(getUser());
        return userWorkouts.stream().map(UserWorkout::getWorkout).collect(Collectors.toList());
    }

    @Override
    public List<WorkoutExercise> readWorkoutExercises() {
        List<Workout> workouts = readWorkouts();
        List<WorkoutExercise> workoutExercises = new ArrayList<>();
        workouts.forEach( workout -> workoutExercises.addAll(workoutExercisesRepository.getAllByWorkout(workout)));
        return workoutExercises;
    }

    @Override
    public List<DoneExercise> readDoneExercises() {
        return doneExerciseRepository.findAllByUser(getUser());
    }

    @Override
    public List<ParameterResult> readParameterResults() {
        List<DoneExercise> doneExercises = readDoneExercises();
        List<ParameterResult> parameterResults = new ArrayList<>();
        for (DoneExercise doneExercise : doneExercises) {
            parameterResults.addAll(parameterResultsRepository.findAllByDoneExercise(doneExercise));
        }
        return parameterResults;
    }

    @Override
    public List<Exercise> readExercises() {
        return readWorkoutExercises().stream()
                .map(WorkoutExercise::getExercise)
                .collect(Collectors.toList());
    }

    @Override
    public List<ExerciseType> readExerciseTypes() {
        return exerciseTypesRepository.findAll();
    }

    @Override
    public List<ExerciseParameter> readExerciseParameters() {
        List<Exercise> exercises = readExercises();
        List<ExerciseParameter> exerciseParameters = new ArrayList<>();
        for (Exercise exercise : exercises) {
            exerciseParameters.addAll(exercisesParametersRepository.getAllByExercise(exercise));
        }
        return exerciseParameters;
    }

    @Override
    public List<Parameter> readParameters() {
        return readExerciseParameters().stream().map(ExerciseParameter::getParameter).collect(Collectors.toList());
    }

    @Override
    public User readUser(Long id) throws CustomException {
        Optional<User> result = usersRepository.findById(id);
        if (result.isEmpty()) {
            throw new CustomException("No such user");
        }
        if (!getUser().getId().equals(result.get().getId())) {
            throw new CustomException("Access to this user is denied");
        }
        return result.get();
    }

    @Override
    public List<UserWorkout> readUserWorkouts() {
        return userWorkoutsRepository.getAllByUser(getUser());
    }



    @Override
    public List<Long> createExercise(List<ExerciseBody> exerciseBody) throws CustomException {
        List<Long> ids = new ArrayList<>();
        for (ExerciseBody body : exerciseBody) {
            Exercise exercise = new Exercise();
            copyAndSave(exercise, body);
            ids.add(exercise.getId());
        }
        return ids;
    }

    @Override
    public List<Long> createExerciseParameter(List<ExerciseParameterBody> bodies) throws CustomException {
        List<Long> ids = new ArrayList<>();
        for (ExerciseParameterBody body : bodies) {
            ExerciseParameter entity = new ExerciseParameter();
            copyAndSave(entity, body);
            ids.add(entity.getId());
        }
        return ids;
    }

    @Override
    public List<Long> createExerciseType(List<ExerciseTypeBody> bodies) {
        List<Long> ids = new ArrayList<>();
        for (ExerciseTypeBody body : bodies) {
            if (exerciseTypesRepository.existsByName(body.getName())) {
                ExerciseType byName = exerciseTypesRepository.findByName(body.getName());
                ids.add(byName.getId());
            } else {
                ExerciseType entity = new ExerciseType();
                entity.setName(body.getName());
                exerciseTypesRepository.save(entity);
                ids.add(entity.getId());
            }
        }
        return ids;
    }

    @Override
    public List<Long> createParameter(List<ParameterBody> bodies) {
        List<Long> ids = new ArrayList<>();
        for (ParameterBody body : bodies) {
            Parameter entity = new Parameter();
            copyAndSave(entity, body);
            ids.add(entity.getId());
        }
        return ids;
    }

    @Override
    public List<Long> createUserWorkout(List<UserWorkoutBody> bodies) throws CustomException {
        List<Long> ids = new ArrayList<>();
        for (UserWorkoutBody body : bodies) {
            UserWorkout entity = new UserWorkout();
            copyAndSave(entity, body);
            ids.add(entity.getId());
        }
        return ids;
    }

    @Override
    public List<Long> createWorkout(List<WorkoutBody> bodies) {
        List<Long> ids = new ArrayList<>();
        for (WorkoutBody body : bodies) {
            Workout entity = new Workout();
            copyAndSave(entity, body);
            ids.add(entity.getId());
        }
        return ids;
    }

    @Override
    public List<Long> createWorkoutExercise(List<WorkoutExerciseBody> bodies) throws CustomException {
        List<Long> ids = new ArrayList<>();
        for (WorkoutExerciseBody body : bodies) {
            WorkoutExercise entity = new WorkoutExercise();
            copyAndSave(entity, body);
            ids.add(entity.getId());
        }
        return ids;
    }

    @Override
    public UserResponse createUser(UserBody userBody) throws CustomException {
        if (userBody.getEmail() == null || userBody.getPassword() == null || userBody.getFirst_name() == null) {
            throw new CustomException("User must have email, password and first name");
        }
        if (usersRepository.findByEmail(userBody.getEmail()) == null) {
            User user = new User();
            copyAndSave(user, userBody);
            return new UserResponse(user);
        } else {
            throw new CustomException("User with email " + userBody.getEmail() + " is already exists");
        }
    }

    @Override
    public List<Long> createDoneExercise(List<DoneExerciseBody> bodies) throws CustomException {
        List<Long> ids = new ArrayList<>();
        for (DoneExerciseBody body : bodies) {
            DoneExercise entity = new DoneExercise();
            copyAndSave(entity, body);
            ids.add(entity.getId());
        }
        return ids;
    }

    @Override
    public List<Long> createParameterResult(List<ParameterResultBody> bodies) {
        List<Long> ids = new ArrayList<>();
        for (ParameterResultBody body : bodies) {
            ParameterResult entity = new ParameterResult();
            copyAndSave(entity, body);
            ids.add(entity.getId());
        }
        return ids;
    }

    private void copyAndSave(ParameterResult entity, ParameterResultBody body) {
        if (body.getDone_exercise_id() != null) {
            Optional<DoneExercise> byId = doneExerciseRepository.findById(body.getDone_exercise_id());
            byId.ifPresent(entity::setDoneExercise);
        }
        if (body.getParameter_id() != null) {
            Optional<Parameter> byId = parametersRepository.findById(body.getParameter_id());
            byId.ifPresent(entity::setParameter);
        }
    }

    @Override
    public UserResponse login() {
        return new UserResponse(getUser());
    }

    @Override
    public Exercise updateExercise(ExerciseBody exerciseBody, long id) throws CustomException {
        Optional<Exercise> optionalExercise = exercisesRepository.findById(id);
        if (optionalExercise.isEmpty()) {
            throw new CustomException("No such exercise");
        }
        Exercise exercise = optionalExercise.get();
        copyAndSave(exercise, exerciseBody);
        return exercise;
    }

    private void copyAndSave(Exercise exercise, ExerciseBody exerciseBody) throws CustomException {
        if (exerciseBody.getExercise_type_id() != null) {
            Optional<ExerciseType> optionalExerciseType = exerciseTypesRepository.findById(exerciseBody.getExercise_type_id());
            if (optionalExerciseType.isEmpty()) {
                throw new CustomException("No such exercise type");
            }
            exercise.setExerciseType(optionalExerciseType.get());
        }

        if (exerciseBody.getName() != null) {
            exercise.setName(exerciseBody.getName());
        }
        exercisesRepository.save(exercise);
    }

    private void copyAndSave(ExerciseParameter exerciseParameter, ExerciseParameterBody exerciseParameterBody) throws CustomException {
        if (exerciseParameterBody.getExercise_id() != null) {
            Optional<Exercise> optionalExercise = exercisesRepository.findById(exerciseParameterBody.getExercise_id());
            if (optionalExercise.isEmpty()) {
                throw new CustomException("No such exercise");
            }
            exerciseParameter.setExercise(optionalExercise.get());
        }

        if (exerciseParameterBody.getParameter_id() != null) {
            Optional<Parameter> optionalParameter = parametersRepository.findById(exerciseParameterBody.getParameter_id());
            if (optionalParameter.isEmpty()) {
                throw new CustomException("No such parameter");
            }
            exerciseParameter.setParameter(optionalParameter.get());
        }
        exercisesParametersRepository.save(exerciseParameter);
    }

    @Override
    public Parameter updateParameter(ParameterBody parameterBody, long id) throws CustomException {
        Optional<Parameter> optionalParameter = parametersRepository.findById(id);
        if (optionalParameter.isEmpty()) {
            throw new CustomException("No such parameter");
        }
        Parameter parameter = optionalParameter.get();
        copyAndSave(parameter, parameterBody);
        return parameter;
    }

    private void copyAndSave(Parameter parameter, ParameterBody parameterBody) {
        if (parameterBody.getName() != null) {
            parameter.setName(parameterBody.getName());
        }

        if (parameterBody.getMeasure_unit() != null) {
            parameter.setMeasureUnit(parameterBody.getMeasure_unit());
        }

        if (parameterBody.getResult_type() != null) {
            parameter.setResultType(parameterBody.getResult_type());
        }
        parametersRepository.save(parameter);
    }

    @Override
    public User updateUser(UserBody userBody, long id) throws CustomException {
        Optional<User> optionalUser = usersRepository.findById(id);
        if (optionalUser.isEmpty()) {
            throw new CustomException("No such user");
        }
        User user = optionalUser.get();
        copyAndSave(user, userBody);
        return user;
    }

    private void copyAndSave(User user, UserBody userBody) {
        if (userBody.getBirthday() != null) {
            user.setBirthday(userBody.getBirthday());
        }

        if (userBody.getAvatarUrl() != null) {
            user.setAvatarUrl(userBody.getAvatarUrl());
        }

        if (userBody.getUid() != null) {
            user.setUid(userBody.getUid());
        }

        if (userBody.getEmail() != null) {
            user.setEmail(userBody.getEmail());
        }

        if (userBody.getFirst_name() != null) {
            user.setFirst_name(userBody.getFirst_name());
        }

        if (userBody.getLast_name() != null) {
            user.setLast_name(userBody.getLast_name());
        }

        if (userBody.getGender() != null) {
            user.setGender(userBody.getGender());
        }

        if (userBody.getPassword() != null) {
            user.setPassword(userBody.getPassword());
        }
        usersRepository.save(user);
    }

    private void copyAndSave(UserWorkout userWorkout, UserWorkoutBody userWorkoutBody) throws CustomException {
        if (userWorkoutBody.getName() != null) {
            userWorkout.setName(userWorkoutBody.getName());
        }

        if (userWorkoutBody.getUser_id() != null) {
            Optional<User> optionalUser = usersRepository.findById(userWorkoutBody.getUser_id());
            if (optionalUser.isEmpty()) {
                throw new CustomException("No such user");
            }
            userWorkout.setUser(optionalUser.get());
        }

        if (userWorkoutBody.getWorkout_id() != null) {
            Optional<Workout> optionalWorkout = workoutsRepository.findById(userWorkoutBody.getWorkout_id());
            if (optionalWorkout.isEmpty()) {
                throw new CustomException("No such optional workout");
            }
            userWorkout.setWorkout(optionalWorkout.get());
        }
        userWorkoutsRepository.save(userWorkout);
    }

    private void copyAndSave(DoneExercise doneExercise, DoneExerciseBody doneExerciseBody) throws CustomException {
        if (doneExerciseBody.getUser_id() != null) {
            Optional<User> optionalParameter = usersRepository.findById(doneExerciseBody.getUser_id());
            if (optionalParameter.isEmpty()) {
                throw new CustomException("No such user");
            }
            doneExercise.setUser(optionalParameter.get());
        }

        if (doneExerciseBody.getExercise_id() != null) {
            Optional<Exercise> optional = exercisesRepository.findById(doneExerciseBody.getExercise_id());
            if (optional.isEmpty()) {
                throw new CustomException("No such exercise");
            }
            doneExercise.setExercise(optional.get());
        }

        if (doneExerciseBody.getDate() != null) {
            doneExercise.setDate(doneExerciseBody.getDate());
        }
        userWorkoutParameterValuesRepository.save(doneExercise);
    }

    @Override
    public Workout updateWorkout(WorkoutBody workoutBody, long id) throws CustomException {
        Optional<Workout> optionalWorkout = workoutsRepository.findById(id);
        if (optionalWorkout.isEmpty()) {
            throw new CustomException("No such workout");
        }
        Workout workout = optionalWorkout.get();
        copyAndSave(workout, workoutBody);
        return workout;
    }

    private void copyAndSave(Workout workout, WorkoutBody workoutBody) {
        if (workoutBody.getName() != null) {
            workout.setName(workoutBody.getName());
        }
        if (workoutBody.getPlanned_time() != null) {
            workout.setPlanned_time(workoutBody.getPlanned_time());
        }
        if (workoutBody.getWeekdays_mask() != null) {
            workout.setWeekdays_mask(workoutBody.getWeekdays_mask());
        }
        workoutsRepository.save(workout);
    }

    private void copyAndSave(WorkoutExercise workoutExercise, WorkoutExerciseBody workoutExerciseBody) throws CustomException {
        if (workoutExerciseBody.getExercise_id() != null) {
            Optional<Exercise> optionalExercise = exercisesRepository.findById(workoutExerciseBody.getExercise_id());
            if (optionalExercise.isEmpty()) {
                throw new CustomException("No such exercise");
            }
            workoutExercise.setExercise(optionalExercise.get());
        }

        if (workoutExerciseBody.getWorkout_id() != null) {
            Optional<Workout> optionalWorkout = workoutsRepository.findById(workoutExerciseBody.getWorkout_id());
            if (optionalWorkout.isEmpty()) {
                throw new CustomException("No such workout");
            }
            workoutExercise.setWorkout(optionalWorkout.get());
        }
        workoutExercisesRepository.save(workoutExercise);
    }

    @Override
    public void deleteExerciseParameter(List<Long> ids) throws CustomException {
        for (Long id: ids) {
            if (exercisesParametersRepository.existsById(id)) {
                exercisesParametersRepository.deleteById(id);
            } else {
                throw new CustomException("No such exercise parameter");
            }
        }
    }

    @Override
    public void deleteUserWorkout(List<Long> ids) throws CustomException {
        for (Long id: ids) {
            if (userWorkoutsRepository.existsById(id)) {
                userWorkoutsRepository.deleteById(id);
            } else {
                throw new CustomException("No such user workout");
            }
        }
    }

    @Override
    public void deleteWorkoutExercise(List<Long> ids) throws CustomException {
        for (Long id: ids) {
            if (workoutExercisesRepository.existsById(id)) {
                workoutExercisesRepository.deleteById(id);
            } else {
                throw new CustomException("No such workout exercise");
            }
        }
    }

    public static class CustomConverters {
        @Component
        public static class StringIdToExercise implements Converter<String, Exercise> {
            @Override
            public Exercise convert(String id) {
                return exercisesRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToExerciseParameter implements Converter<String, ExerciseParameter> {
            @Override
            public ExerciseParameter convert(String id) {
                return exercisesParametersRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToExerciseType implements Converter<String, ExerciseType> {
            @Override
            public ExerciseType convert(String id) {
                return exerciseTypesRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToParameter implements Converter<String, Parameter> {
            @Override
            public Parameter convert(String id) {
                return parametersRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToUser implements Converter<String, User> {
            @Override
            public User convert(String id) {
                return usersRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToUserWorkout implements Converter<String, UserWorkout> {
            @Override
            public UserWorkout convert(String id) {
                return userWorkoutsRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToUserWorkoutParameterValue implements Converter<String, DoneExercise> {
            @Override
            public DoneExercise convert(String id) {
                return userWorkoutParameterValuesRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToWorkout implements Converter<String, Workout> {
            @Override
            public Workout convert(String id) {
                return workoutsRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToWorkoutExercise implements Converter<String, WorkoutExercise> {
            @Override
            public WorkoutExercise convert(String id) {
                return workoutExercisesRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToDoneExercise implements Converter<String, DoneExercise> {
            @Override
            public DoneExercise convert(String id) {
                return doneExerciseRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }

        @Component
        public static class StringIdToParameterResult implements Converter<String, ParameterResult> {
            @Override
            public ParameterResult convert(String id) {
                return parameterResultsRepository.findById(Long.parseLong(id)).orElse(null);
            }
        }
    }
}
