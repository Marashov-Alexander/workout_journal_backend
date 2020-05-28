package journal.workout.controllers;

import journal.workout.exceptions.CustomException;
import journal.workout.models.requests.*;
import journal.workout.services.WJService;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class AppController {

    final WJService wjService;

    public AppController(WJService wjService) {
        this.wjService = wjService;
    }

    @GetMapping("/users/login")
    public ResponseEntity<Object> login() {
        return new ResponseEntity<>(wjService.login(), HttpStatus.OK);
    }

    @GetMapping("/workouts/all")
    public ResponseEntity<Object> readWorkouts() {
        return new ResponseEntity<>(wjService.readWorkouts(), HttpStatus.OK);
    }

    @GetMapping("/exercises/all")
    public ResponseEntity<Object> readExercises() {
        return new ResponseEntity<>(wjService.readExercises(), HttpStatus.OK);
    }

    @GetMapping("/parameter-results/all")
    public ResponseEntity<Object> readParameterResults() {
        return new ResponseEntity<>(wjService.readParameterResults(), HttpStatus.OK);
    }

    @GetMapping("/done-exercises/all")
    public ResponseEntity<Object> readDoneExercises() {
        return new ResponseEntity<>(wjService.readDoneExercises(), HttpStatus.OK);
    }

    @GetMapping("/exercise-types/all")
    public ResponseEntity<Object> readExerciseTypes() {
        return new ResponseEntity<>(wjService.readExerciseTypes(), HttpStatus.OK);
    }

    @GetMapping("/parameters/all")
    public ResponseEntity<Object> readParameters() {
        return new ResponseEntity<>(wjService.readParameters(), HttpStatus.OK);
    }

    @GetMapping("/users/{user-id}")
    public ResponseEntity<Object> readUser(@PathVariable(name = "user-id") Long id) {
        try {
            return new ResponseEntity<>(wjService.readUser(id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user-workouts/all")
    public ResponseEntity<Object> readUserWorkouts() {
        return new ResponseEntity<>(wjService.readUserWorkouts(), HttpStatus.OK);
    }

    @PostMapping("/parameter-results/create")
    public ResponseEntity<Object> createParameterResults(@Valid @RequestBody List<ParameterResultBody> bodies) {
        return new ResponseEntity<>(wjService.createParameterResult(bodies), HttpStatus.CREATED);
    }

    @PostMapping("/done-exercises/create")
    public ResponseEntity<Object> createDoneExercises(@Valid @RequestBody List<DoneExerciseBody> bodies) {
        try {
            return new ResponseEntity<>(wjService.createDoneExercise(bodies), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/exercises/create")
    public ResponseEntity<Object> createExercises(@Valid @RequestBody List<ExerciseBody> exercises) {
        try {
            return new ResponseEntity<>(wjService.createExercise(exercises), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/exercise-parameters/create")
    public ResponseEntity<Object> createExerciseParameters(@Valid @RequestBody List<ExerciseParameterBody> exerciseParameters) {
        try {
            return new ResponseEntity<>(wjService.createExerciseParameter(exerciseParameters), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/exercise-types/create")
    public ResponseEntity<Object> createExerciseTypes(@Valid @RequestBody List<ExerciseTypeBody> exerciseTypes) {
        return new ResponseEntity<>(wjService.createExerciseType(exerciseTypes), HttpStatus.CREATED);
    }

    @PostMapping("/parameters/create")
    public ResponseEntity<Object> createParameters(@Valid @RequestBody List<ParameterBody> parameters) {
        try {
            return new ResponseEntity<>(wjService.createParameter(parameters), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/users/create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserBody user) {
        try {
            return new ResponseEntity<>(wjService.createUser(user), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user-workouts/create")
    public ResponseEntity<Object> createUserWorkouts(@Valid @RequestBody List<UserWorkoutBody> userWorkouts) {
        try {
            return new ResponseEntity<>(wjService.createUserWorkout(userWorkouts), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/workouts/create")
    public ResponseEntity<Object> createWorkout(@Valid @RequestBody List<WorkoutBody> workouts) {
        return new ResponseEntity<>(wjService.createWorkout(workouts), HttpStatus.CREATED);
    }

    @PostMapping("/workout-exercises/create")
    public ResponseEntity<Object> createWorkoutExercise(@Valid @RequestBody List<WorkoutExerciseBody> workoutExercises) {
        try {
            return new ResponseEntity<>(wjService.createWorkoutExercise(workoutExercises), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/exercises/{id}")
    public ResponseEntity<Object> updateExercise(@Valid @RequestBody ExerciseBody exercise, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateExercise(exercise, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/parameters/{id}")
    public ResponseEntity<Object> updateParameter(@Valid @RequestBody ParameterBody parameter, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateParameter(parameter, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserBody user, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateUser(user, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/workouts/{id}")
    public ResponseEntity<Object> updateWorkout(@Valid @RequestBody WorkoutBody workout, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateWorkout(workout, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/exercise-parameters")
    public ResponseEntity<Object> deleteExerciseParameter(@RequestBody List<Long> ids) {
        try {
            wjService.deleteExerciseParameter(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/user-workouts")
    public ResponseEntity<Object> deleteUserWorkout(@RequestBody List<Long> ids) {
        try {
            wjService.deleteUserWorkout(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/workout-exercises")
    public ResponseEntity<Object> deleteWorkoutExercise(@RequestBody List<Long> ids) {
        try {
            wjService.deleteWorkoutExercise(ids);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @InitBinder
    private void dateBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        CustomDateEditor editor = new CustomDateEditor(dateFormat, true);
        binder.registerCustomEditor(Date.class, editor);
    }

}
