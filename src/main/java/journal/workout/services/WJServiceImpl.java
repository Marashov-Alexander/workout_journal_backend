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

import java.util.List;
import java.util.Optional;

@Service
public class WJServiceImpl implements WJService {

    static ExercisesParametersRepository exercisesParametersRepository;
    static ExercisesRepository exercisesRepository;
    static ExerciseTypesRepository exerciseTypesRepository;
    static MeasureUnitsRepository measureUnitsRepository;
    static ParametersRepository parametersRepository;
    static ParameterTypesRepository parameterTypesRepository;
    static UsersRepository usersRepository;
    static UserWorkoutParameterValuesRepository userWorkoutParameterValuesRepository;
    static UserWorkoutsRepository userWorkoutsRepository;
    static WorkoutExercisesRepository workoutExercisesRepository;
    static WorkoutsRepository workoutsRepository;

    public WJServiceImpl(ExercisesParametersRepository exercisesParametersRepository,
                         ExercisesRepository exercisesRepository,
                         ExerciseTypesRepository exerciseTypesRepository,
                         MeasureUnitsRepository measureUnitsRepository,
                         ParametersRepository parametersRepository,
                         ParameterTypesRepository parameterTypesRepository,
                         UsersRepository usersRepository,
                         UserWorkoutParameterValuesRepository userWorkoutParameterValuesRepository,
                         UserWorkoutsRepository userWorkoutsRepository,
                         WorkoutExercisesRepository workoutExercisesRepository,
                         WorkoutsRepository workoutsRepository) {
        WJServiceImpl.exercisesParametersRepository = exercisesParametersRepository;
        WJServiceImpl.exercisesRepository = exercisesRepository;
        WJServiceImpl.exerciseTypesRepository = exerciseTypesRepository;
        WJServiceImpl.measureUnitsRepository = measureUnitsRepository;
        WJServiceImpl.parametersRepository = parametersRepository;
        WJServiceImpl.parameterTypesRepository = parameterTypesRepository;
        WJServiceImpl.usersRepository = usersRepository;
        WJServiceImpl.userWorkoutParameterValuesRepository = userWorkoutParameterValuesRepository;
        WJServiceImpl.userWorkoutsRepository = userWorkoutsRepository;
        WJServiceImpl.workoutExercisesRepository = workoutExercisesRepository;
        WJServiceImpl.workoutsRepository = workoutsRepository;
    }

    @Override
    public List<Workout> readWorkouts() {
        return workoutsRepository.findAll();
    }

    @Override
    public Workout readWorkout(Long id) throws CustomException {
        Optional<Workout> workout = workoutsRepository.findById(id);
        if (workout.isEmpty()) {
            throw new CustomException("No such workout");
        } else {
            return workout.get();
        }
    }

    @Override
    public List<Exercise> readExercises() {
        return exercisesRepository.findAll();
    }

    @Override
    public List<Exercise> readExercisesByType(Long exerciseTypeId) throws CustomException {
        Optional<ExerciseType> exerciseTypeOptional = exerciseTypesRepository.findById(exerciseTypeId);
        if (exerciseTypeOptional.isEmpty()) {
            throw new CustomException("No such exercise type");
        } else {
            return exercisesRepository.findAllByExerciseType(exerciseTypeOptional.get()).orElse(null);
        }
    }

    @Override
    public List<WorkoutExercise> readExercisesByWorkout(Long workoutId) throws CustomException {

        Optional<Workout> workoutOptional = workoutsRepository.findById(workoutId);
        if (workoutOptional.isEmpty()) {
            throw new CustomException("No such workout");
        } else {
            return workoutExercisesRepository.findAllByWorkout(workoutOptional.get()).orElse(null);
        }
    }

    @Override
    public Exercise readExercise(Long id) throws CustomException {

        Optional<Exercise> result = exercisesRepository.findById(id);
        if (result.isEmpty()) {
            throw new CustomException("No such exercise");
        } else {
            return result.get();
        }
    }

    @Override
    public List<ExerciseType> readExerciseTypes() {
        return exerciseTypesRepository.findAll();
    }

    @Override
    public ExerciseType readExerciseType(Long id) throws CustomException {

        Optional<ExerciseType> result = exerciseTypesRepository.findById(id);
        if (result.isEmpty()) {
            throw new CustomException("No such exercise type");
        } else {
            return result.get();
        }
    }

    @Override
    public List<Parameter> readParameters() {
        return parametersRepository.findAll();
    }

    @Override
    public List<ExerciseParameter> readParametersByExercise(Long exerciseId) throws CustomException {

        Optional<Exercise> exerciseOptional = exercisesRepository.findById(exerciseId);
        if (exerciseOptional.isEmpty()) {
            throw new CustomException("No such exercise");
        } else {
            return exercisesParametersRepository.findAllByExercise(exerciseOptional.get()).orElse(null);
        }
    }

    @Override
    public Parameter readParameter(Long id) throws CustomException {
        Optional<Parameter> result = parametersRepository.findById(id);
        if (result.isEmpty()) {
            throw new CustomException("No such parameter");
        } else {
            return result.get();
        }
    }

    @Override
    public List<ParameterType> readParameterTypes() {
        return parameterTypesRepository.findAll();
    }

    @Override
    public ParameterType readParameterType(Long id) throws CustomException {
        Optional<ParameterType> result = parameterTypesRepository.findById(id);
        if (result.isEmpty()) {
            throw new CustomException("No such parameter type");
        } else {
            return result.get();
        }
    }

    @Override
    public List<MeasureUnit> readMeasureUnits() {
        return measureUnitsRepository.findAll();
    }

    @Override
    public MeasureUnit readMeasureUnit(Long id) throws CustomException {
        Optional<MeasureUnit> result = measureUnitsRepository.findById(id);
        if (result.isEmpty()) {
            throw new CustomException("No such measure unit");
        } else {
            return result.get();
        }
    }

    @Override
    public List<User> readUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User readUser(Long id) throws CustomException {
        Optional<User> result = usersRepository.findById(id);
        if (result.isEmpty()) {
            throw new CustomException("No such user");
        } else {
            return result.get();
        }
    }

    @Override
    public List<UserWorkout> readUserWorkouts() {
        return userWorkoutsRepository.findAll();
    }

    @Override
    public UserWorkout readUserWorkout(Long id) throws CustomException {
        Optional<UserWorkout> result = userWorkoutsRepository.findById(id);
        if (result.isEmpty()) {
            throw new CustomException("No such user workout");
        } else {
            return result.get();
        }
    }

    @Override
    public List<UserWorkoutParameterValue> readUserWorkoutParameterValues(Long userWorkoutId) throws CustomException {
        Optional<UserWorkout> userWorkoutOptional = userWorkoutsRepository.findById(userWorkoutId);
        if (userWorkoutOptional.isEmpty()) {
            throw new CustomException("No such user workout");
        } else {
            return userWorkoutParameterValuesRepository.findAllByUserWorkout(userWorkoutOptional.get()).orElse(null);
        }
    }

    @Override
    public Long readUserWorkoutParameterValue(Long userWorkoutId, Long parameterId) throws CustomException {
        Optional<UserWorkout> optionalUserWorkout = userWorkoutsRepository.findById(userWorkoutId);
        Optional<Parameter> optionalParameter = parametersRepository.findById(parameterId);
        if (optionalParameter.isEmpty()) {
            throw new CustomException("No such parameter");
        }
        if (optionalUserWorkout.isEmpty()) {
            throw new CustomException("No such user workout");
        }
        Optional<Long> optionalValue = userWorkoutParameterValuesRepository.findValueByUserWorkoutAndParameter(optionalUserWorkout.get(), optionalParameter.get());
        if (optionalValue.isEmpty()) {
            throw new CustomException("No such optional value");
        }
        return optionalValue.get();
    }

    @Override
    public Exercise createExercise(ExerciseBody exerciseBody) throws CustomException {
        Exercise exercise = new Exercise();
        copyAndSave(exercise, exerciseBody);
        return exercise;
    }

    @Override
    public ExerciseParameter createExerciseParameter(ExerciseParameterBody exerciseParameterBody) throws CustomException {
        ExerciseParameter exerciseParameter = new ExerciseParameter();
        copyAndSave(exerciseParameter, exerciseParameterBody);
        return exerciseParameter;
    }

    @Override
    public ExerciseType createExerciseType(ExerciseTypeBody exerciseTypeBody) {
        ExerciseType exerciseType = new ExerciseType();
        copyAndSave(exerciseType, exerciseTypeBody);
        return exerciseType;
    }

    @Override
    public MeasureUnit createMeasureUnit(MeasureUnitBody measureUnitBody) {
        MeasureUnit measureUnit = new MeasureUnit();
        copyAndSave(measureUnit, measureUnitBody);
        return measureUnit;
    }

    @Override
    public Parameter createParameter(ParameterBody parameterBody) throws CustomException {
        Parameter parameter = new Parameter();
        copyAndSave(parameter, parameterBody);
        return parameter;
    }

    @Override
    public ParameterType createParameterType(ParameterTypeBody parameterTypeBody) {
        ParameterType parameterType = new ParameterType();
        copyAndSave(parameterType, parameterTypeBody);
        return parameterType;
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
    public UserWorkout createUserWorkout(UserWorkoutBody userWorkoutBody) throws CustomException {

        UserWorkout userWorkout = new UserWorkout();
        copyAndSave(userWorkout, userWorkoutBody);
        return userWorkout;
    }

    @Override
    public UserWorkoutParameterValue createUserWorkoutParameterValue(UserWorkoutParameterValueBody userWorkoutParameterValueBody) throws CustomException {
        UserWorkoutParameterValue userWorkoutParameterValue = new UserWorkoutParameterValue();
        copyAndSave(userWorkoutParameterValue, userWorkoutParameterValueBody);
        return userWorkoutParameterValue;
    }

    @Override
    public Workout createWorkout(WorkoutBody workoutBody) {
        Workout workout = new Workout();
        copyAndSave(workout, workoutBody);
        return workout;
    }

    @Override
    public WorkoutExercise createWorkoutExercise(WorkoutExerciseBody workoutExerciseBody) throws CustomException {
        WorkoutExercise workoutExercise = new WorkoutExercise();
        copyAndSave(workoutExercise, workoutExerciseBody);
        return workoutExercise;
    }

    @Override
    public UserResponse login() {
        var userCr = (org.springframework.security.core.userdetails.User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User user = usersRepository.findByEmail(userCr.getUsername());
        return new UserResponse(user);
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
        if (exerciseBody.getExerciseTypeId() != null) {
            Optional<ExerciseType> optionalExerciseType = exerciseTypesRepository.findById(exerciseBody.getExerciseTypeId());
            if (optionalExerciseType.isEmpty()) {
                throw new CustomException("No such exercise type");
            }
            exercise.setExerciseType(optionalExerciseType.get());
        }

        if (exerciseBody.getDescription() != null) {
            exercise.setDescription(exerciseBody.getDescription());
        }

        if (exerciseBody.getName() != null) {
            exercise.setName(exerciseBody.getName());
        }
        exercisesRepository.save(exercise);
    }

    @Override
    public ExerciseParameter updateExerciseParameter(ExerciseParameterBody exerciseParameterBody, long id) throws CustomException {
        Optional<ExerciseParameter> optionalExerciseParameter = exercisesParametersRepository.findById(id);
        if (optionalExerciseParameter.isEmpty()) {
            throw new CustomException("No such exercise parameter");
        }
        ExerciseParameter exerciseParameter = optionalExerciseParameter.get();
        copyAndSave(exerciseParameter, exerciseParameterBody);
        return exerciseParameter;
    }

    private void copyAndSave(ExerciseParameter exerciseParameter, ExerciseParameterBody exerciseParameterBody) throws CustomException {
        if (exerciseParameterBody.getExerciseId() != null) {
            Optional<Exercise> optionalExercise = exercisesRepository.findById(exerciseParameterBody.getExerciseId());
            if (optionalExercise.isEmpty()) {
                throw new CustomException("No such exercise");
            }
            exerciseParameter.setExercise(optionalExercise.get());
        }

        if (exerciseParameterBody.getParameterId() != null) {
            Optional<Parameter> optionalParameter = parametersRepository.findById(exerciseParameterBody.getParameterId());
            if (optionalParameter.isEmpty()) {
                throw new CustomException("No such parameter");
            }
            exerciseParameter.setParameter(optionalParameter.get());
        }
        exercisesParametersRepository.save(exerciseParameter);
    }

    @Override
    public ExerciseType updateExerciseType(ExerciseTypeBody exerciseTypeBody, long id) throws CustomException {
        Optional<ExerciseType> optionalExerciseType = exerciseTypesRepository.findById(id);
        if (optionalExerciseType.isEmpty()) {
            throw new CustomException("No such exercise type");
        }
        ExerciseType exerciseType = optionalExerciseType.get();
        copyAndSave(exerciseType, exerciseTypeBody);
        return exerciseType;
    }

    private void copyAndSave(ExerciseType exerciseType, ExerciseTypeBody exerciseTypeBody) {
        if (exerciseTypeBody.getName() != null) {
            exerciseType.setName(exerciseTypeBody.getName());
        }
        exerciseTypesRepository.save(exerciseType);
    }

    @Override
    public MeasureUnit updateMeasureUnit(MeasureUnitBody measureUnitBody, long id) throws CustomException {
        Optional<MeasureUnit> optionalMeasureUnit = measureUnitsRepository.findById(id);
        if (optionalMeasureUnit.isEmpty()) {
            throw new CustomException("No such measure unit");
        }
        MeasureUnit measureUnit = optionalMeasureUnit.get();
        copyAndSave(measureUnit, measureUnitBody);
        return measureUnit;
    }

    private void copyAndSave(MeasureUnit measureUnit, MeasureUnitBody measureUnitBody) {
        if (measureUnitBody.getName() != null) {
            measureUnit.setName(measureUnitBody.getName());
        }

        if (measureUnitBody.getAcronym() != null) {
            measureUnit.setAcronym(measureUnitBody.getAcronym());
        }
        measureUnitsRepository.save(measureUnit);
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

    private void copyAndSave(Parameter parameter, ParameterBody parameterBody) throws CustomException {
        if (parameterBody.getName() != null) {
            parameter.setName(parameterBody.getName());
        }

        if (parameterBody.getMeasureUnitId() != null) {
            Optional<MeasureUnit> optionalMeasureUnit = measureUnitsRepository.findById(parameterBody.getMeasureUnitId());
            if (optionalMeasureUnit.isEmpty()) {
                throw new CustomException("No such measure unit");
            }
            parameter.setMeasureUnit(optionalMeasureUnit.get());
        }

        if (parameterBody.getParameterTypeId() != null) {
            Optional<ParameterType> optionalParameterType = parameterTypesRepository.findById(parameterBody.getParameterTypeId());
            if (optionalParameterType.isEmpty()) {
                throw new CustomException("No such parameter type");
            }
            parameter.setParameterType(optionalParameterType.get());
        }
        parametersRepository.save(parameter);
    }

    @Override
    public ParameterType updateParameterType(ParameterTypeBody parameterTypeBody, long id) throws CustomException {
        Optional<ParameterType> optionalParameterType = parameterTypesRepository.findById(id);
        if (optionalParameterType.isEmpty()) {
            throw new CustomException("No such parameter type");
        }
        ParameterType parameterType = optionalParameterType.get();
        copyAndSave(parameterType, parameterTypeBody);
        return parameterType;
    }

    private void copyAndSave(ParameterType parameterType, ParameterTypeBody parameterTypeBody) {
        if (parameterTypeBody.getName() != null) {
            parameterType.setName(parameterTypeBody.getName());
        }
        parameterTypesRepository.save(parameterType);
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

    @Override
    public UserWorkout updateUserWorkout(UserWorkoutBody userWorkoutBody, long id) throws CustomException {
        Optional<UserWorkout> optionalUserWorkout = userWorkoutsRepository.findById(id);
        if (optionalUserWorkout.isEmpty()) {
            throw new CustomException("No such user workout");
        }
        UserWorkout userWorkout = optionalUserWorkout.get();
        copyAndSave(userWorkout, userWorkoutBody);
        return userWorkout;
    }

    private void copyAndSave(UserWorkout userWorkout, UserWorkoutBody userWorkoutBody) throws CustomException {
        if (userWorkoutBody.getComments() != null) {
            userWorkout.setComments(userWorkoutBody.getComments());
        }
        if (userWorkoutBody.getName() != null) {
            userWorkout.setName(userWorkoutBody.getName());
        }

        if (userWorkoutBody.getUserId() != null) {
            Optional<User> optionalUser = usersRepository.findById(userWorkoutBody.getUserId());
            if (optionalUser.isEmpty()) {
                throw new CustomException("No such user");
            }
            userWorkout.setUser(optionalUser.get());
        }

        if (userWorkoutBody.getWorkoutId() != null) {
            Optional<Workout> optionalWorkout = workoutsRepository.findById(userWorkoutBody.getWorkoutId());
            if (optionalWorkout.isEmpty()) {
                throw new CustomException("No such optional workout");
            }
            userWorkout.setWorkout(optionalWorkout.get());
        }
        userWorkoutsRepository.save(userWorkout);
    }

    @Override
    public UserWorkoutParameterValue updateUserWorkoutParameterValue(UserWorkoutParameterValueBody userWorkoutParameterValueBody, long id) throws CustomException {
        Optional<UserWorkoutParameterValue> optionalUserWorkoutParameterValue = userWorkoutParameterValuesRepository.findById(id);
        if (optionalUserWorkoutParameterValue.isEmpty()) {
            throw new CustomException("No such user workout parameter value");
        }
        UserWorkoutParameterValue userWorkoutParameterValue = optionalUserWorkoutParameterValue.get();
        copyAndSave(userWorkoutParameterValue, userWorkoutParameterValueBody);
        return userWorkoutParameterValue;
    }

    private void copyAndSave(UserWorkoutParameterValue userWorkoutParameterValue, UserWorkoutParameterValueBody userWorkoutParameterValueBody) throws CustomException {
        if (userWorkoutParameterValueBody.getParameterId() != null) {
            Optional<Parameter> optionalParameter = parametersRepository.findById(userWorkoutParameterValueBody.getParameterId());
            if (optionalParameter.isEmpty()) {
                throw new CustomException("No such parameter");
            }
            userWorkoutParameterValue.setParameter(optionalParameter.get());
        }

        if (userWorkoutParameterValueBody.getUserWorkoutId() != null) {
            Optional<UserWorkout> optionalUserWorkout = userWorkoutsRepository.findById(userWorkoutParameterValueBody.getUserWorkoutId());
            if (optionalUserWorkout.isEmpty()) {
                throw new CustomException("No such user workout");
            }
            userWorkoutParameterValue.setUserWorkout(optionalUserWorkout.get());
        }

        if (userWorkoutParameterValueBody.getValue() != null) {
            userWorkoutParameterValue.setValue(userWorkoutParameterValueBody.getValue());
        }
        userWorkoutParameterValuesRepository.save(userWorkoutParameterValue);
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
        if (workoutBody.getDescription() != null) {
            workout.setDescription(workoutBody.getDescription());
        }
        if (workoutBody.getName() != null) {
            workout.setName(workoutBody.getName());
        }
        workoutsRepository.save(workout);
    }

    @Override
    public WorkoutExercise updateWorkoutExercise(WorkoutExerciseBody workoutExerciseBody, long id) throws CustomException {
        Optional<WorkoutExercise> optionalWorkoutExercise = workoutExercisesRepository.findById(id);
        if (optionalWorkoutExercise.isEmpty()) {
            throw new CustomException("No such workout exercise");
        }
        WorkoutExercise workoutExercise = optionalWorkoutExercise.get();
        copyAndSave(workoutExercise, workoutExerciseBody);
        return workoutExercise;
    }

    private void copyAndSave(WorkoutExercise workoutExercise, WorkoutExerciseBody workoutExerciseBody) throws CustomException {
        if (workoutExerciseBody.getExerciseId() != null) {
            Optional<Exercise> optionalExercise = exercisesRepository.findById(workoutExerciseBody.getExerciseId());
            if (optionalExercise.isEmpty()) {
                throw new CustomException("No such exercise");
            }
            workoutExercise.setExercise(optionalExercise.get());
        }

        if (workoutExerciseBody.getWorkoutId() != null) {
            Optional<Workout> optionalWorkout = workoutsRepository.findById(workoutExerciseBody.getWorkoutId());
            if (optionalWorkout.isEmpty()) {
                throw new CustomException("No such workout");
            }
            workoutExercise.setWorkout(optionalWorkout.get());
        }
        workoutExercisesRepository.save(workoutExercise);
    }

    @Override
    public void deleteExercise(long id) throws CustomException {
        if (exercisesRepository.existsById(id)) {
            exercisesRepository.deleteById(id);
        } else {
            throw new CustomException("No such exercise");
        }
    }

    @Override
    public void deleteExerciseParameter(long id) throws CustomException {
        if (exercisesParametersRepository.existsById(id)) {
            exercisesParametersRepository.deleteById(id);
        } else {
            throw new CustomException("No such exercise parameter");
        }
    }

    @Override
    public void deleteExerciseType(long id) throws CustomException {
        if (exerciseTypesRepository.existsById(id)) {
            exerciseTypesRepository.deleteById(id);
        } else {
            throw new CustomException("No such exercise type");
        }
    }

    @Override
    public void deleteMeasureUnit(long id) throws CustomException {
        if (measureUnitsRepository.existsById(id)) {
            measureUnitsRepository.deleteById(id);
        } else {
            throw new CustomException("No such measure unit");
        }
    }

    @Override
    public void deleteParameter(long id) throws CustomException {
        if (parametersRepository.existsById(id)) {
            parametersRepository.deleteById(id);
        } else {
            throw new CustomException("No such parameter");
        }
    }

    @Override
    public void deleteParameterType(long id) throws CustomException {
        if (parameterTypesRepository.existsById(id)) {
            parameterTypesRepository.deleteById(id);
        } else {
            throw new CustomException("No such parameter type");
        }
    }

    @Override
    public void deleteUser(long id) throws CustomException {
        if (usersRepository.existsById(id)) {
            usersRepository.deleteById(id);
        } else {
            throw new CustomException("No such user");
        }
    }

    @Override
    public void deleteUserWorkout(long id) throws CustomException {
        if (userWorkoutsRepository.existsById(id)) {
            userWorkoutsRepository.deleteById(id);
        } else {
            throw new CustomException("No such user workout");
        }
    }

    @Override
    public void deleteUserWorkoutParameterValue(long id) throws CustomException {
        if (userWorkoutParameterValuesRepository.existsById(id)) {
            userWorkoutParameterValuesRepository.deleteById(id);
        } else {
            throw new CustomException("No such user workout parameter value");
        }
    }

    @Override
    public void deleteWorkout(long id) throws CustomException {

        if (workoutsRepository.existsById(id)) {
            workoutsRepository.deleteById(id);
        } else {
            throw new CustomException("No such workout");
        }
    }

    @Override
    public void deleteWorkoutExercise(long id) throws CustomException {
        if (workoutExercisesRepository.existsById(id)) {
            workoutExercisesRepository.deleteById(id);
        } else {
            throw new CustomException("No such workout exercise");
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
        public static class StringIdToMeasureUnit implements Converter<String, MeasureUnit> {
            @Override
            public MeasureUnit convert(String id) {
                return measureUnitsRepository.findById(Long.parseLong(id)).orElse(null);
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
        public static class StringIdToParameterType implements Converter<String, ParameterType> {
            @Override
            public ParameterType convert(String id) {
                return parameterTypesRepository.findById(Long.parseLong(id)).orElse(null);
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
        public static class StringIdToUserWorkoutParameterValue implements Converter<String, UserWorkoutParameterValue> {
            @Override
            public UserWorkoutParameterValue convert(String id) {
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
    }
}
