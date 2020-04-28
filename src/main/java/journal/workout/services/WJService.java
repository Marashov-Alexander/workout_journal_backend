package journal.workout.services;

import journal.workout.models.*;
import journal.workout.models.requests.*;

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

    Exercise createExercise(Exercise exercise);
    ExerciseParameter createExerciseParameter(ExerciseParameter exerciseParameter);
    ExerciseType createExerciseType(ExerciseType exerciseType);
    MeasureUnit createMeasureUnit(MeasureUnit measureUnit);
    Parameter createParameter(Parameter parameter);
    ParameterType createParameterType(ParameterType parameterType);
    User createUser(User user);
    UserWorkout createUserWorkout(UserWorkout userWorkout);
    UserWorkoutParameterValue createUserWorkoutParameterValue(UserWorkoutParameterValue userWorkoutParameterValue);
    Workout createWorkout(Workout workout);
    WorkoutExercise createWorkoutExercise(WorkoutExercise workoutExercise);

    Exercise updateExercise(ExerciseBody exercise, long id);
    ExerciseParameter updateExerciseParameter(ExerciseParameterBody exerciseParameter, long id);
    ExerciseType updateExerciseType(ExerciseTypeBody exerciseType, long id);
    MeasureUnit updateMeasureUnit(MeasureUnitBody measureUnit, long id);
    Parameter updateParameter(ParameterBody parameter, long id);
    ParameterType updateParameterType(ParameterTypeBody parameterType, long id);
    User updateUser(UserBody user, long id);
    UserWorkout updateUserWorkout(UserWorkoutBody userWorkout, long id);
    UserWorkoutParameterValue updateUserWorkoutParameterValue(UserWorkoutParameterValueBody userWorkoutParameterValue, long id);
    Workout updateWorkout(WorkoutBody workout, long id);
    WorkoutExercise updateWorkoutExercise(WorkoutExerciseBody workoutExercise, long id);

    void deleteExercise(long id);
    void deleteExerciseParameter(long id);
    void deleteExerciseType(long id);
    void deleteMeasureUnit(long id);
    void deleteParameter(long id);
    void deleteParameterType(long id);
    void deleteUser(long id);
    void deleteUserWorkout(long id);
    void deleteUserWorkoutParameterValue(long id);
    void deleteWorkout(long id);
    void deleteWorkoutExercise(long id);

}
