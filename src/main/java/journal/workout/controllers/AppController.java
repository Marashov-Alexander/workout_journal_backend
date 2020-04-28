package journal.workout.controllers;

import journal.workout.models.*;
import journal.workout.services.WJService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AppController {

    final WJService wjService;

    public AppController(WJService wjService) {
        this.wjService = wjService;
    }

    @GetMapping("/workouts/all")
    @ResponseBody
    List<Workout> readWorkouts() {
        return wjService.readWorkouts();
    }

    @GetMapping("/workouts/{workout-id}")
    @ResponseBody
    Workout readWorkout(@PathVariable(name = "workout-id") Long workoutId) {
        return wjService.readWorkout(workoutId);
    }

    @GetMapping("/exercises/all")
    @ResponseBody
    List<Exercise> readExercises() {
        return wjService.readExercises();
    }

    @GetMapping("/exercises/by-type/{exercise-type-id}")
    @ResponseBody
    List<Exercise> readExercisesByType(@PathVariable(name = "exercise-type-id") ExerciseType exerciseType) {
        return wjService.readExercisesByType(exerciseType);
    }

    @GetMapping("/exercises/by-workout/{workout-id}")
    @ResponseBody
    List<WorkoutExercise> readExercisesByWorkout(@PathVariable(name = "workout-id") Workout workout) {
        return wjService.readExercisesByWorkout(workout);
    }

    @GetMapping("/exercises/{exercise-id}")
    @ResponseBody
    Exercise readExercise(@PathVariable(name = "exercise-id") Long id) {
        return wjService.readExercise(id);
    }

    @GetMapping("/exercise-types/all")
    @ResponseBody
    List<ExerciseType> readExerciseTypes() {
        return wjService.readExerciseTypes();
    }

    @GetMapping("/exercise-types/{exercise-type-id}")
    @ResponseBody
    ExerciseType readExerciseType(@PathVariable(name = "exercise-type-id") Long id) {
        return wjService.readExerciseType(id);
    }

    @GetMapping("/parameters/all")
    @ResponseBody
    List<Parameter> readParameters() {
        return wjService.readParameters();
    }

    @GetMapping("/parameters/by-exercise/{exercise-id}")
    @ResponseBody
    List<ExerciseParameter> readParametersByExercise(@PathVariable(name = "exercise-id") Exercise exercise) {
        return wjService.readParametersByExercise(exercise);
    }

    @GetMapping("/parameters/{parameter-id}")
    @ResponseBody
    Parameter readParameter(@PathVariable(name = "parameter-id") Long id) {
        return wjService.readParameter(id);
    }

    @GetMapping("/parameter-types/all")
    @ResponseBody
    List<ParameterType> readParameterTypes() {
        return wjService.readParameterTypes();
    }

    @GetMapping("/parameters-types/{parameter-type-id}")
    @ResponseBody
    ParameterType readParameterType(@PathVariable(name = "parameter-type-id") Long id) {
        return wjService.readParameterType(id);
    }

    @GetMapping("/measure-units/all")
    @ResponseBody
    List<MeasureUnit> readMeasureUnits() {
        return wjService.readMeasureUnits();
    }

    @GetMapping("/measure-units/{measure-unit-id}")
    @ResponseBody
    MeasureUnit readMeasureUnit(@PathVariable(name = "measure-unit-id") Long id) {
        return wjService.readMeasureUnit(id);
    }

    @GetMapping("/users/all")
    @ResponseBody
    List<User> readUsers() {
        return wjService.readUsers();
    }

    @GetMapping("/users/{user-id}")
    @ResponseBody
    User readUser(@PathVariable(name = "user-id") Long id) {
        return wjService.readUser(id);
    }

    @GetMapping("/user-workouts/all")
    @ResponseBody
    List<UserWorkout> readUserWorkouts() {
        return wjService.readUserWorkouts();
    }

    @GetMapping("/user-workouts/{user-workout-id}")
    @ResponseBody
    UserWorkout readUserWorkout(@PathVariable(name = "user-workout-id") Long id) {
        return wjService.readUserWorkout(id);
    }

    @GetMapping("/user-workouts/parameters/{user-workout-id}")
    @ResponseBody
    List<UserWorkoutParameterValue> readUserWorkoutParameterValues(UserWorkout userWorkout) {
        return wjService.readUserWorkoutParameterValues(userWorkout);
    }

    @GetMapping("/user-workouts/parameters")
    @ResponseBody
    Long readUserWorkoutParameterValue(
            @RequestParam(name = "user-workout-id") UserWorkout userWorkout,
            @RequestParam(name = "parameter-id") Parameter parameter) {
        return wjService.readUserWorkoutParameterValue(userWorkout, parameter);
    }

}
