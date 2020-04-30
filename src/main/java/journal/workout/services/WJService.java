package journal.workout.services;

import journal.workout.exceptions.CustomException;
import journal.workout.models.*;
import journal.workout.models.requests.*;

import java.util.List;

public interface WJService {

    List<Workout> readWorkouts();
    Workout readWorkout(Long id) throws CustomException;

    List<Exercise> readExercises();

    List<Exercise> readExercisesByType(Long exerciseTypeId) throws CustomException;

    List<WorkoutExercise> readExercisesByWorkout(Long workoutId) throws CustomException;

    Exercise readExercise(Long id) throws CustomException;

    List<ExerciseType> readExerciseTypes();
    ExerciseType readExerciseType(Long id) throws CustomException;

    List<Parameter> readParameters();

    List<ExerciseParameter> readParametersByExercise(Long exerciseId) throws CustomException;

    Parameter readParameter(Long id) throws CustomException;

    List<ParameterType> readParameterTypes();
    ParameterType readParameterType(Long id) throws CustomException;

    List<MeasureUnit> readMeasureUnits();
    MeasureUnit readMeasureUnit(Long id) throws CustomException;

    List<User> readUsers();
    User readUser(Long id) throws CustomException;

    List<UserWorkout> readUserWorkouts(); // нужна авторизация
    UserWorkout readUserWorkout(Long id) throws CustomException;

    List<UserWorkoutParameterValue> readUserWorkoutParameterValues(Long userWorkoutId) throws CustomException;

    Long readUserWorkoutParameterValue(Long userWorkoutId, Long parameterId) throws CustomException;

    Exercise createExercise(ExerciseBody exerciseBody) throws CustomException;
    ExerciseParameter createExerciseParameter(ExerciseParameterBody exerciseParameterBody) throws CustomException;
    ExerciseType createExerciseType(ExerciseTypeBody exerciseTypeBody);
    MeasureUnit createMeasureUnit(MeasureUnitBody measureUnitBody);
    Parameter createParameter(ParameterBody parameterBody) throws CustomException;
    ParameterType createParameterType(ParameterTypeBody parameterTypeBody);
    User createUser(UserBody userBody) throws CustomException;
    UserWorkout createUserWorkout(UserWorkoutBody userWorkoutBody) throws CustomException;
    UserWorkoutParameterValue createUserWorkoutParameterValue(UserWorkoutParameterValueBody userWorkoutParameterValueBody) throws CustomException;
    Workout createWorkout(WorkoutBody workoutBody);
    WorkoutExercise createWorkoutExercise(WorkoutExerciseBody workoutExerciseBody) throws CustomException;

    Exercise updateExercise(ExerciseBody exercise, long id) throws CustomException;
    ExerciseParameter updateExerciseParameter(ExerciseParameterBody exerciseParameter, long id) throws CustomException;
    ExerciseType updateExerciseType(ExerciseTypeBody exerciseType, long id) throws CustomException;
    MeasureUnit updateMeasureUnit(MeasureUnitBody measureUnit, long id) throws CustomException;
    Parameter updateParameter(ParameterBody parameter, long id) throws CustomException;
    ParameterType updateParameterType(ParameterTypeBody parameterType, long id) throws CustomException;
    User updateUser(UserBody user, long id) throws CustomException;
    UserWorkout updateUserWorkout(UserWorkoutBody userWorkout, long id) throws CustomException;
    UserWorkoutParameterValue updateUserWorkoutParameterValue(UserWorkoutParameterValueBody userWorkoutParameterValue, long id) throws CustomException;
    Workout updateWorkout(WorkoutBody workout, long id) throws CustomException;
    WorkoutExercise updateWorkoutExercise(WorkoutExerciseBody workoutExercise, long id) throws CustomException;

    void deleteExercise(long id) throws CustomException;
    void deleteExerciseParameter(long id) throws CustomException;
    void deleteExerciseType(long id) throws CustomException;
    void deleteMeasureUnit(long id) throws CustomException;
    void deleteParameter(long id) throws CustomException;
    void deleteParameterType(long id) throws CustomException;
    void deleteUser(long id) throws CustomException;
    void deleteUserWorkout(long id) throws CustomException;
    void deleteUserWorkoutParameterValue(long id) throws CustomException;
    void deleteWorkout(long id) throws CustomException;
    void deleteWorkoutExercise(long id) throws CustomException;

}
