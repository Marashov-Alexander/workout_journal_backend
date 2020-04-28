package journal.workout.controllers;

import journal.workout.models.*;
import journal.workout.models.requests.*;
import journal.workout.services.WJService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AppController {

    final WJService wjService;

    public AppController(WJService wjService) {
        this.wjService = wjService;
    }

    @GetMapping("/workouts/all")
    @ResponseBody
    public List<Workout> readWorkouts() {
        return wjService.readWorkouts();
    }

    @GetMapping("/workouts/{workout-id}")
    @ResponseBody
    public Workout readWorkout(@PathVariable(name = "workout-id") Long workoutId) {
        return wjService.readWorkout(workoutId);
    }

    @GetMapping("/exercises/all")
    @ResponseBody
    public List<Exercise> readExercises() {
        return wjService.readExercises();
    }

    @GetMapping("/exercises/by-type/{exercise-type-id}")
    @ResponseBody
    public List<Exercise> readExercisesByType(@PathVariable(name = "exercise-type-id") ExerciseType exerciseType) {
        return wjService.readExercisesByType(exerciseType);
    }

    @GetMapping("/exercises/by-workout/{workout-id}")
    @ResponseBody
    public List<WorkoutExercise> readExercisesByWorkout(@PathVariable(name = "workout-id") Workout workout) {
        return wjService.readExercisesByWorkout(workout);
    }

    @GetMapping("/exercises/{exercise-id}")
    @ResponseBody
    public Exercise readExercise(@PathVariable(name = "exercise-id") Long id) {
        return wjService.readExercise(id);
    }

    @GetMapping("/exercise-types/all")
    @ResponseBody
    public List<ExerciseType> readExerciseTypes() {
        return wjService.readExerciseTypes();
    }

    @GetMapping("/exercise-types/{exercise-type-id}")
    @ResponseBody
    public ExerciseType readExerciseType(@PathVariable(name = "exercise-type-id") Long id) {
        return wjService.readExerciseType(id);
    }

    @GetMapping("/parameters/all")
    @ResponseBody
    public List<Parameter> readParameters() {
        return wjService.readParameters();
    }

    @GetMapping("/parameters/by-exercise/{exercise-id}")
    @ResponseBody
    public List<ExerciseParameter> readParametersByExercise(@PathVariable(name = "exercise-id") Exercise exercise) {
        return wjService.readParametersByExercise(exercise);
    }

    @GetMapping("/parameters/{parameter-id}")
    @ResponseBody
    public Parameter readParameter(@PathVariable(name = "parameter-id") Long id) {
        return wjService.readParameter(id);
    }

    @GetMapping("/parameter-types/all")
    @ResponseBody
    public List<ParameterType> readParameterTypes() {
        return wjService.readParameterTypes();
    }

    @GetMapping("/parameters-types/{parameter-type-id}")
    @ResponseBody
    public ParameterType readParameterType(@PathVariable(name = "parameter-type-id") Long id) {
        return wjService.readParameterType(id);
    }

    @GetMapping("/measure-units/all")
    @ResponseBody
    public List<MeasureUnit> readMeasureUnits() {
        return wjService.readMeasureUnits();
    }

    @GetMapping("/measure-units/{measure-unit-id}")
    @ResponseBody
    public MeasureUnit readMeasureUnit(@PathVariable(name = "measure-unit-id") Long id) {
        return wjService.readMeasureUnit(id);
    }

    @GetMapping("/users/all")
    @ResponseBody
    public List<User> readUsers() {
        return wjService.readUsers();
    }

    @GetMapping("/users/{user-id}")
    @ResponseBody
    public User readUser(@PathVariable(name = "user-id") Long id) {
        return wjService.readUser(id);
    }

    @GetMapping("/user-workouts/all")
    @ResponseBody
    public List<UserWorkout> readUserWorkouts() {
        return wjService.readUserWorkouts();
    }

    @GetMapping("/user-workouts/{user-workout-id}")
    @ResponseBody
    public UserWorkout readUserWorkout(@PathVariable(name = "user-workout-id") Long id) {
        return wjService.readUserWorkout(id);
    }

    @GetMapping("/user-workouts/parameters/{user-workout-id}")
    @ResponseBody
    public List<UserWorkoutParameterValue> readUserWorkoutParameterValues(@PathVariable(name = "user-workout-id") UserWorkout userWorkout) {
        return wjService.readUserWorkoutParameterValues(userWorkout);
    }

    @GetMapping("/user-workouts/parameters")
    @ResponseBody
    public Long readUserWorkoutParameterValue(
            @RequestParam(name = "user-workout-id") UserWorkout userWorkout,
            @RequestParam(name = "parameter-id") Parameter parameter) {
        return wjService.readUserWorkoutParameterValue(userWorkout, parameter);
    }

    @PostMapping("/exercises/")
    @ResponseStatus(HttpStatus.CREATED)
    public Exercise createExercise(@Valid @RequestBody Exercise exercise) {
        return wjService.createExercise(exercise);
    }

    @PostMapping("/exercise-parameters/")
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciseParameter createExerciseParameter(@Valid @RequestBody ExerciseParameter exerciseParameter) {
        return wjService.createExerciseParameter(exerciseParameter);
    }

    @PostMapping("/exercise-types/")
    @ResponseStatus(HttpStatus.CREATED)
    public ExerciseType createExerciseType(@Valid @RequestBody ExerciseType exerciseType) {
        return wjService.createExerciseType(exerciseType);
    }

    @PostMapping("/measure-units/")
    @ResponseStatus(HttpStatus.CREATED)
    public MeasureUnit createMeasureUnit(@Valid @RequestBody MeasureUnit measureUnit) {
        return wjService.createMeasureUnit(measureUnit);
    }

    @PostMapping("/parameters/")
    @ResponseStatus(HttpStatus.CREATED)
    public Parameter createParameter(@Valid @RequestBody Parameter parameter) {
        return wjService.createParameter(parameter);
    }

    @PostMapping("/parameter-types/")
    @ResponseStatus(HttpStatus.CREATED)
    public ParameterType createParameterType(@Valid @RequestBody ParameterType parameterType) {
        return wjService.createParameterType(parameterType);
    }

    @PostMapping("/users/")
    @ResponseStatus(HttpStatus.CREATED)
    public User createUser(@Valid @RequestBody User user) {
        return wjService.createUser(user);
    }

    @PostMapping("/user-workouts/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserWorkout createUserWorkout(@Valid @RequestBody UserWorkout userWorkout) {
        return wjService.createUserWorkout(userWorkout);
    }

    @PostMapping("/user-workout-parameter-values/")
    @ResponseStatus(HttpStatus.CREATED)
    public UserWorkoutParameterValue createUserWorkoutParameterValue(@Valid @RequestBody UserWorkoutParameterValue userWorkoutParameterValue) {
        return wjService.createUserWorkoutParameterValue(userWorkoutParameterValue);
    }

    @PostMapping("/workouts/")
    @ResponseStatus(HttpStatus.CREATED)
    public Workout createWorkout(@Valid @RequestBody Workout workout) {
        return wjService.createWorkout(workout);
    }

    @PostMapping("/workout-exercises/")
    @ResponseStatus(HttpStatus.CREATED)
    public WorkoutExercise createWorkoutExercise(@Valid @RequestBody WorkoutExercise workoutExercise) {
        return wjService.createWorkoutExercise(workoutExercise);
    }

    @PutMapping("/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Exercise updateExercise(@Valid @RequestBody ExerciseBody exercise, @PathVariable(name = "id") long id) {
        return wjService.updateExercise(exercise, id);
    }

    @PutMapping("/exercise-parameters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExerciseParameter updateExerciseParameter(@Valid @RequestBody ExerciseParameterBody exerciseParameter, @PathVariable(name = "id") long id) {
        return wjService.updateExerciseParameter(exerciseParameter, id);
    }

    @PutMapping("/exercise-types/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ExerciseType updateExerciseType(@Valid @RequestBody ExerciseTypeBody exerciseType, @PathVariable(name = "id") long id) {
        return wjService.updateExerciseType(exerciseType, id);
    }

    @PutMapping("/measure-units/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MeasureUnit updateMeasureUnit(@Valid @RequestBody MeasureUnitBody measureUnit, @PathVariable(name = "id") long id) {
        return wjService.updateMeasureUnit(measureUnit, id);
    }

    @PutMapping("/parameters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Parameter updateParameter(@Valid @RequestBody ParameterBody parameter, @PathVariable(name = "id") long id) {
        return wjService.updateParameter(parameter, id);
    }

    @PutMapping("/parameter-types/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ParameterType updateParameterType(@Valid @RequestBody ParameterTypeBody parameterType, @PathVariable(name = "id") long id) {
        return wjService.updateParameterType(parameterType, id);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public User updateUser(@Valid @RequestBody UserBody user, @PathVariable(name = "id") long id) {
        return wjService.updateUser(user, id);
    }

    @PutMapping("/user-workouts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserWorkout updateUserWorkout(@Valid @RequestBody UserWorkoutBody userWorkout, @PathVariable(name = "id") long id) {
        return wjService.updateUserWorkout(userWorkout, id);
    }

    @PutMapping("/user-workout-parameter-values/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserWorkoutParameterValue updateUserWorkoutParameterValue(@Valid @RequestBody UserWorkoutParameterValueBody userWorkoutParameterValue, @PathVariable(name = "id") long id) {
        return wjService.updateUserWorkoutParameterValue(userWorkoutParameterValue, id);
    }

    @PutMapping("/workouts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Workout updateWorkout(@Valid @RequestBody WorkoutBody workout, @PathVariable(name = "id") long id) {
        return wjService.updateWorkout(workout, id);
    }

    @PutMapping("/workout-exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public WorkoutExercise updateWorkoutExercise(@Valid @RequestBody WorkoutExerciseBody workoutExercise, @PathVariable(name = "id") long id) {
        return wjService.updateWorkoutExercise(workoutExercise, id);
    }

    @DeleteMapping("/exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteExercise(@PathVariable(name = "id") long id) {
        wjService.deleteExercise(id);
    }

    @DeleteMapping("/exercise-parameters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteExerciseParameter(@PathVariable(name = "id") long id) {
        wjService.deleteExerciseParameter(id);
    }

    @DeleteMapping("/exercise-types/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteExerciseType(@PathVariable(name = "id") long id) {
        wjService.deleteExerciseType(id);
    }

    @DeleteMapping("/measure-units/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteMeasureUnit(@PathVariable(name = "id") long id) {
        wjService.deleteMeasureUnit(id);
    }

    @DeleteMapping("/parameters/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteParameter(@PathVariable(name = "id") long id) {
        wjService.deleteParameter(id);
    }

    @DeleteMapping("/parameter-types/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteParameterType(@PathVariable(name = "id") long id) {
        wjService.deleteParameterType(id);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable(name = "id") long id) {
        wjService.deleteUser(id);
    }

    @DeleteMapping("/user-workouts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserWorkout(@PathVariable(name = "id") long id) {
        wjService.deleteUserWorkout(id);
    }

    @DeleteMapping("/user-workout-parameter-values/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUserWorkoutParameterValue(@PathVariable(name = "id") long id) {
        wjService.deleteUserWorkoutParameterValue(id);
    }

    @DeleteMapping("/workouts/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWorkout(@PathVariable(name = "id") long id) {
        wjService.deleteWorkout(id);
    }

    @DeleteMapping("/workout-exercises/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteWorkoutExercise(@PathVariable(name = "id") long id) {
        wjService.deleteWorkoutExercise(id);
    }

}
