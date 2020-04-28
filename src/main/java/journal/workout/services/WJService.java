package journal.workout.services;

import journal.workout.models.*;

import java.util.List;

public interface WJService {

    List<Workout> readWorkouts();
    Workout readWorkout(Long id);

    List<Exercise> readExercises();

    List<Exercise> readExercisesByType(ExerciseType exerciseType);

    List<WorkoutExercise> readExercisesByWorkout(Workout workout);

    Exercise readExercise(Long id);

    List<ExerciseType> readExerciseTypes();
    ExerciseType readExerciseType(Long id);

    List<Parameter> readParameters();

    List<ExerciseParameter> readParametersByExercise(Exercise exercise);

    Parameter readParameter(Long id);

    List<ParameterType> readParameterTypes();
    ParameterType readParameterType(Long id);

    List<MeasureUnit> readMeasureUnits();
    MeasureUnit readMeasureUnit(Long id);

    List<User> readUsers();
    User readUser(Long id);

    List<UserWorkout> readUserWorkouts(); // нужна авторизация
    UserWorkout readUserWorkout(Long id);

    List<UserWorkoutParameterValue> readUserWorkoutParameterValues(UserWorkout userWorkout);

    Long readUserWorkoutParameterValue(UserWorkout userWorkout, Parameter parameter);
}
