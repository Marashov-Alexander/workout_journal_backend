package journal.workout.services;

import journal.workout.exceptions.CustomException;
import journal.workout.models.*;
import journal.workout.models.requests.*;
import journal.workout.models.responses.UserResponse;

import java.util.List;

public interface WJService {

    List<Workout> readWorkouts();
    List<Exercise> readExercises();
    List<ExerciseType> readExerciseTypes();
    List<Parameter> readParameters();
    User readUser(Long id) throws CustomException;
    List<UserWorkout> readUserWorkouts();
    List<ExerciseParameter> readExerciseParameters();
    List<WorkoutExercise> readWorkoutExercises();
    List<DoneExercise> readDoneExercises();
    List<ParameterResult> readParameterResults();

    List<Long> createExercise(List<ExerciseBody> exerciseBody) throws CustomException;
    List<Long> createExerciseParameter(List<ExerciseParameterBody> exerciseParameterBody) throws CustomException;
    List<Long> createExerciseType(List<ExerciseTypeBody> exerciseTypeBody);
    List<Long> createParameter(List<ParameterBody> parameterBody) throws CustomException;
    UserResponse createUser(UserBody userBody) throws CustomException;
    List<Long> createUserWorkout(List<UserWorkoutBody> userWorkoutBody) throws CustomException;
    List<Long> createWorkout(List<WorkoutBody> workoutBody);
    List<Long> createWorkoutExercise(List<WorkoutExerciseBody> workoutExerciseBody) throws CustomException;
    List<Long> createDoneExercise(List<DoneExerciseBody> doneExercise) throws CustomException;
    List<Long> createParameterResult(List<ParameterResultBody> parameterResult);

    UserResponse login();

    Exercise updateExercise(ExerciseBody exercise, long id) throws CustomException;
    Parameter updateParameter(ParameterBody parameter, long id) throws CustomException;
    User updateUser(UserBody user, long id) throws CustomException;
    Workout updateWorkout(WorkoutBody workout, long id) throws CustomException;

    void deleteExerciseParameter(List<Long> ids) throws CustomException;
    void deleteUserWorkout(List<Long> ids) throws CustomException;
    void deleteWorkoutExercise(List<Long> ids) throws CustomException;

}
