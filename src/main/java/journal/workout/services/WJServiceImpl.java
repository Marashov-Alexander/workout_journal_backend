package journal.workout.services;

import journal.workout.models.*;
import journal.workout.repositories.*;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

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
