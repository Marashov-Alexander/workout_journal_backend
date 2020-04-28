package journal.workout.services;

import journal.workout.models.*;
import journal.workout.models.requests.*;
import journal.workout.repositories.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

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
    public Workout readWorkout(Long id) {
        return workoutsRepository.findById(id).orElse(null);
    }

    @Override
    public List<Exercise> readExercises() {
        return exercisesRepository.findAll();
    }

    @Override
    public List<Exercise> readExercisesByType(ExerciseType exerciseType) {
        return exercisesRepository.findAllByExerciseType(exerciseType);
    }

    @Override
    public List<WorkoutExercise> readExercisesByWorkout(Workout workout) {
        return workoutExercisesRepository.findAllByWorkout(workout);
    }

    @Override
    public Exercise readExercise(Long id) {
        return exercisesRepository.findById(id).orElse(null);
    }

    @Override
    public List<ExerciseType> readExerciseTypes() {
        return exerciseTypesRepository.findAll();
    }

    @Override
    public ExerciseType readExerciseType(Long id) {
        return exerciseTypesRepository.findById(id).orElse(null);
    }

    @Override
    public List<Parameter> readParameters() {
        return parametersRepository.findAll();
    }

    @Override
    public List<ExerciseParameter> readParametersByExercise(Exercise exercise) {
        return exercisesParametersRepository.findAllByExercise(exercise);
    }

    @Override
    public Parameter readParameter(Long id) {
        return parametersRepository.findById(id).orElse(null);
    }

    @Override
    public List<ParameterType> readParameterTypes() {
        return parameterTypesRepository.findAll();
    }

    @Override
    public ParameterType readParameterType(Long id) {
        return parameterTypesRepository.findById(id).orElse(null);
    }

    @Override
    public List<MeasureUnit> readMeasureUnits() {
        return measureUnitsRepository.findAll();
    }

    @Override
    public MeasureUnit readMeasureUnit(Long id) {
        return measureUnitsRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> readUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User readUser(Long id) {
        return usersRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserWorkout> readUserWorkouts() {
        return userWorkoutsRepository.findAll();
    }

    @Override
    public UserWorkout readUserWorkout(Long id) {
        return userWorkoutsRepository.findById(id).orElse(null);
    }

    @Override
    public List<UserWorkoutParameterValue> readUserWorkoutParameterValues(UserWorkout userWorkout) {
        return userWorkoutParameterValuesRepository.findAllByUserWorkout(userWorkout);
    }

    @Override
    public Long readUserWorkoutParameterValue(UserWorkout userWorkout, Parameter parameter) {
        return userWorkoutParameterValuesRepository.findValueByUserWorkoutAndParameter(userWorkout, parameter);
    }

    @Override
    public Exercise createExercise(Exercise exercise) {
        exercisesRepository.save(exercise);
        return exercise;
    }

    @Override
    public ExerciseParameter createExerciseParameter(ExerciseParameter exerciseParameter) {
        exercisesParametersRepository.save(exerciseParameter);
        return exerciseParameter;
    }

    @Override
    public ExerciseType createExerciseType(ExerciseType exerciseType) {
        exerciseTypesRepository.save(exerciseType);
        return exerciseType;
    }

    @Override
    public MeasureUnit createMeasureUnit(MeasureUnit measureUnit) {
        measureUnitsRepository.save(measureUnit);
        return measureUnit;
    }

    @Override
    public Parameter createParameter(Parameter parameter) {
        parametersRepository.save(parameter);
        return parameter;
    }

    @Override
    public ParameterType createParameterType(ParameterType parameterType) {
        parameterTypesRepository.save(parameterType);
        return parameterType;
    }

    @Override
    public User createUser(User user) {
        usersRepository.save(user);
        return user;
    }

    @Override
    public UserWorkout createUserWorkout(UserWorkout userWorkout) {
        userWorkoutsRepository.save(userWorkout);
        return userWorkout;
    }

    @Override
    public UserWorkoutParameterValue createUserWorkoutParameterValue(UserWorkoutParameterValue userWorkoutParameterValue) {
        userWorkoutParameterValuesRepository.save(userWorkoutParameterValue);
        return userWorkoutParameterValue;
    }

    @Override
    public Workout createWorkout(Workout workout) {
        workoutsRepository.save(workout);
        return workout;
    }

    @Override
    public WorkoutExercise createWorkoutExercise(WorkoutExercise workoutExercise) {
        workoutExercisesRepository.save(workoutExercise);
        return workoutExercise;
    }

    @Override
    public Exercise updateExercise(ExerciseBody exerciseBody, long id) {
        Exercise exercise = exercisesRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (exerciseBody.getExerciseTypeId() != null) {
            ExerciseType exerciseType = exerciseTypesRepository.findById(exerciseBody.getExerciseTypeId()).orElseThrow(NoSuchElementException::new);
            exercise.setExerciseType(exerciseType);
        }

        if (exerciseBody.getDescription() != null) {
            exercise.setDescription(exerciseBody.getDescription());
        }

        if (exerciseBody.getName() != null) {
            exercise.setName(exerciseBody.getName());
        }
        exercisesRepository.save(exercise);
        return exercise;
    }

    @Override
    public ExerciseParameter updateExerciseParameter(ExerciseParameterBody exerciseParameterBody, long id) {
        ExerciseParameter exerciseParameter = exercisesParametersRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (exerciseParameterBody.getExerciseId() != null) {
            Exercise exercise = exercisesRepository.findById(exerciseParameterBody.getExerciseId()).orElseThrow(NoSuchElementException::new);
            exerciseParameter.setExercise(exercise);
        }

        if (exerciseParameterBody.getParameterId() != null) {
            Parameter parameter = parametersRepository.findById(exerciseParameterBody.getParameterId()).orElseThrow(NoSuchElementException::new);
            exerciseParameter.setParameter(parameter);
        }
        exercisesParametersRepository.save(exerciseParameter);
        return exerciseParameter;
    }

    @Override
    public ExerciseType updateExerciseType(ExerciseTypeBody exerciseTypeBody, long id) {
        ExerciseType exerciseType = exerciseTypesRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (exerciseTypeBody.getName() != null) {
            exerciseType.setName(exerciseTypeBody.getName());
        }
        exerciseTypesRepository.save(exerciseType);
        return exerciseType;
    }

    @Override
    public MeasureUnit updateMeasureUnit(MeasureUnitBody measureUnitBody, long id) {
        MeasureUnit measureUnit = measureUnitsRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (measureUnitBody.getName() != null) {
            measureUnit.setName(measureUnitBody.getName());
        }

        if (measureUnitBody.getAcronym() != null) {
            measureUnit.setAcronym(measureUnitBody.getAcronym());
        }
        measureUnitsRepository.save(measureUnit);
        return measureUnit;
    }

    @Override
    public Parameter updateParameter(ParameterBody parameterBody, long id) {
        Parameter parameter = parametersRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (parameterBody.getName() != null) {
            parameter.setName(parameterBody.getName());
        }

        if (parameterBody.getMeasureUnitId() != null) {
            MeasureUnit measureUnit = measureUnitsRepository.findById(parameterBody.getMeasureUnitId()).orElseThrow(NoSuchElementException::new);
            parameter.setMeasureUnit(measureUnit);
        }

        if (parameterBody.getParameterTypeId() != null) {
            ParameterType parameterType = parameterTypesRepository.findById(parameterBody.getParameterTypeId()).orElseThrow(NoSuchElementException::new);
            parameter.setParameterType(parameterType);
        }
        parametersRepository.save(parameter);
        return parameter;
    }

    @Override
    public ParameterType updateParameterType(ParameterTypeBody parameterTypeBody, long id) {
        ParameterType parameterType = parameterTypesRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (parameterTypeBody.getName() != null) {
            parameterType.setName(parameterTypeBody.getName());
        }
        parameterTypesRepository.save(parameterType);
        return parameterType;
    }

    @Override
    public User updateUser(UserBody userBody, long id) {
        User user = usersRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (userBody.getAge() != null) {
            user.setAge(userBody.getAge());
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

        if (userBody.getIsMale() != null) {
            user.setIsMale(userBody.getIsMale());
        }

        if (userBody.getPassword() != null) {
            user.setPassword(userBody.getPassword());
        }
        usersRepository.save(user);
        return user;
    }

    @Override
    public UserWorkout updateUserWorkout(UserWorkoutBody userWorkoutBody, long id) {
        UserWorkout userWorkout = userWorkoutsRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (userWorkoutBody.getComments() != null) {
            userWorkout.setComments(userWorkoutBody.getComments());
        }
        if (userWorkoutBody.getName() != null) {
            userWorkout.setName(userWorkoutBody.getName());
        }

        if (userWorkoutBody.getUserId() != null) {
            User user = usersRepository.findById(userWorkoutBody.getUserId()).orElseThrow(NoSuchElementException::new);
            userWorkout.setUser(user);
        }

        if (userWorkoutBody.getWorkoutId() != null) {
            Workout workout = workoutsRepository.findById(userWorkoutBody.getWorkoutId()).orElseThrow(NoSuchElementException::new);
            userWorkout.setWorkout(workout);
        }
        userWorkoutsRepository.save(userWorkout);
        return userWorkout;
    }

    @Override
    public UserWorkoutParameterValue updateUserWorkoutParameterValue(UserWorkoutParameterValueBody userWorkoutParameterValueBody, long id) {
        UserWorkoutParameterValue userWorkoutParameterValue = userWorkoutParameterValuesRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (userWorkoutParameterValueBody.getParameterId() != null) {
            Parameter parameter = parametersRepository.findById(userWorkoutParameterValueBody.getParameterId()).orElseThrow(NoSuchElementException::new);
            userWorkoutParameterValue.setParameter(parameter);
        }

        if (userWorkoutParameterValueBody.getUserWorkoutId() != null) {
            UserWorkout userWorkout = userWorkoutsRepository.findById(userWorkoutParameterValueBody.getUserWorkoutId()).orElseThrow(NoSuchElementException::new);
            userWorkoutParameterValue.setUserWorkout(userWorkout);
        }

        if (userWorkoutParameterValueBody.getValue() != null) {
            userWorkoutParameterValue.setValue(userWorkoutParameterValueBody.getValue());
        }
        userWorkoutParameterValuesRepository.save(userWorkoutParameterValue);
        return userWorkoutParameterValue;
    }

    @Override
    public Workout updateWorkout(WorkoutBody workoutBody, long id) {
        Workout workout = workoutsRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (workoutBody.getDescription() != null) {
            workout.setDescription(workoutBody.getDescription());
        }
        if (workoutBody.getName() != null) {
            workout.setName(workoutBody.getName());
        }
        workoutsRepository.save(workout);
        return workout;
    }

    @Override
    public WorkoutExercise updateWorkoutExercise(WorkoutExerciseBody workoutExerciseBody, long id) {
        WorkoutExercise workoutExercise = workoutExercisesRepository.findById(id).orElseThrow(NoSuchElementException::new);
        if (workoutExerciseBody.getExerciseId() != null) {
            Exercise exercise = exercisesRepository.findById(workoutExerciseBody.getExerciseId()).orElseThrow(NoSuchElementException::new);
            workoutExercise.setExercise(exercise);
        }

        if (workoutExerciseBody.getWorkoutId() != null) {
            Workout workout = workoutsRepository.findById(workoutExerciseBody.getWorkoutId()).orElseThrow(NoSuchElementException::new);
            workoutExercise.setWorkout(workout);
        }
        workoutExercisesRepository.save(workoutExercise);
        return workoutExercise;
    }

    @Override
    public void deleteExercise(long id) {
        exercisesRepository.deleteById(id);
    }

    @Override
    public void deleteExerciseParameter(long id) {
        exercisesParametersRepository.deleteById(id);
    }

    @Override
    public void deleteExerciseType(long id) {
        exerciseTypesRepository.deleteById(id);
    }

    @Override
    public void deleteMeasureUnit(long id) {
        measureUnitsRepository.deleteById(id);
    }

    @Override
    public void deleteParameter(long id) {
        parametersRepository.deleteById(id);
    }

    @Override
    public void deleteParameterType(long id) {
        parameterTypesRepository.deleteById(id);
    }

    @Override
    public void deleteUser(long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public void deleteUserWorkout(long id) {
        userWorkoutsRepository.deleteById(id);
    }

    @Override
    public void deleteUserWorkoutParameterValue(long id) {
        userWorkoutParameterValuesRepository.deleteById(id);
    }

    @Override
    public void deleteWorkout(long id) {
        workoutsRepository.deleteById(id);
    }

    @Override
    public void deleteWorkoutExercise(long id) {
        workoutExercisesRepository.deleteById(id);
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
