package journal.workout.controllers;

import journal.workout.exceptions.CustomException;
import journal.workout.models.*;
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

@RestController
public class AppController {

    final WJService wjService;

    public AppController(WJService wjService) {
        this.wjService = wjService;
    }

    @GetMapping("/workouts/all")
    public ResponseEntity<Object> readWorkouts() {
        return new ResponseEntity<>(wjService.readWorkouts(), HttpStatus.OK);
    }

    @GetMapping("/workouts/{workout-id}")
    public ResponseEntity<Object> readWorkout(@PathVariable(name = "workout-id") Long workoutId) {
        try {
            return new ResponseEntity<>(wjService.readWorkout(workoutId), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/exercises/all")
    public ResponseEntity<Object> readExercises() {
        return new ResponseEntity<>(wjService.readExercises(), HttpStatus.OK);
    }

    @GetMapping("/exercises/by-type/{exercise-type-id}")
    public ResponseEntity<Object> readExercisesByType(@PathVariable(name = "exercise-type-id") Long id) {
        try {
            return new ResponseEntity<>(wjService.readExercisesByType(id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/exercises/by-workout/{workout-id}")
    public ResponseEntity<Object> readExercisesByWorkout(@PathVariable(name = "workout-id") Long workout) {
        try {
            return new ResponseEntity<>(wjService.readExercisesByWorkout(workout), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/exercises/{exercise-id}")
    public ResponseEntity<Object> readExercise(@PathVariable(name = "exercise-id") Long id) {
        try {
            return new ResponseEntity<>(wjService.readExercise(id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/exercise-types/all")
    public ResponseEntity<Object> readExerciseTypes() {
        return new ResponseEntity<>(wjService.readExerciseTypes(), HttpStatus.OK);
    }

    @GetMapping("/exercise-types/{exercise-type-id}")
    public ResponseEntity<Object> readExerciseType(@PathVariable(name = "exercise-type-id") Long id) {
        try {
            return new ResponseEntity<>(wjService.readExerciseType(id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/parameters/all")
    public ResponseEntity<Object> readParameters() {
        return new ResponseEntity<>(wjService.readParameters(), HttpStatus.OK);
    }

    @GetMapping("/parameters/by-exercise/{exercise-id}")
    public ResponseEntity<Object> readParametersByExercise(@PathVariable(name = "exercise-id") Long exercise) {
        try {
            return new ResponseEntity<>(wjService.readParametersByExercise(exercise), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/parameters/{parameter-id}")
    public ResponseEntity<Object> readParameter(@PathVariable(name = "parameter-id") Long id) {
        try {
            return new ResponseEntity<>(wjService.readParameter(id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/parameter-types/all")
    public ResponseEntity<Object> readParameterTypes() {
         return new ResponseEntity<>(wjService.readParameterTypes(), HttpStatus.OK);
    }

    @GetMapping("/parameter-types/{parameter-type-id}")
    public ResponseEntity<Object> readParameterType(@PathVariable(name = "parameter-type-id") Long id) {
        try {
            return new ResponseEntity<>(wjService.readParameterType(id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/measure-units/all")
    public ResponseEntity<Object> readMeasureUnits() {
        return new ResponseEntity<>(wjService.readMeasureUnits(), HttpStatus.OK);
    }

    @GetMapping("/measure-units/{measure-unit-id}")
    public ResponseEntity<Object> readMeasureUnit(@PathVariable(name = "measure-unit-id") Long id) {
        try {
            return new ResponseEntity<>(wjService.readMeasureUnit(id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/all")
    public ResponseEntity<Object> readUsers() {
        return new ResponseEntity<>(wjService.readUsers(), HttpStatus.OK);
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

    @GetMapping("/user-workouts/{user-workout-id}")
    public ResponseEntity<Object> readUserWorkout(@PathVariable(name = "user-workout-id") Long id) {
        try {
            return new ResponseEntity<>(wjService.readUserWorkout(id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user-workouts/parameters/{user-workout-id}")
    public ResponseEntity<Object> readUserWorkoutParameterValues(@PathVariable(name = "user-workout-id") Long userWorkout) {
        try {
            return new ResponseEntity<>(wjService.readUserWorkoutParameterValues(userWorkout), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/user-workouts/parameters")
    public ResponseEntity<Object> readUserWorkoutParameterValue(
            @RequestParam(name = "user-workout-id") Long userWorkout,
            @RequestParam(name = "parameter-id") Long parameter) {
        try {
            return new ResponseEntity<>(wjService.readUserWorkoutParameterValue(userWorkout, parameter), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/exercises/create")
    public ResponseEntity<Object> createExercise(@Valid @RequestBody ExerciseBody exercise) {
        try {
            return new ResponseEntity<>(wjService.createExercise(exercise), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/exercise-parameters/create")
    public ResponseEntity<Object> createExerciseParameter(@Valid @RequestBody ExerciseParameterBody exerciseParameter) {
        try {
            return new ResponseEntity<>(wjService.createExerciseParameter(exerciseParameter), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/exercise-types/create")
    public ResponseEntity<Object> createExerciseType(@Valid @RequestBody ExerciseTypeBody exerciseType) {
        return new ResponseEntity<>(wjService.createExerciseType(exerciseType), HttpStatus.CREATED);
    }

    @PostMapping("/measure-units/create")
    public ResponseEntity<Object> createMeasureUnit(@Valid @RequestBody MeasureUnitBody measureUnit) {
        return new ResponseEntity<>(wjService.createMeasureUnit(measureUnit), HttpStatus.CREATED);
    }

    @PostMapping("/parameters/create")
    public ResponseEntity<Object> createParameter(@Valid @RequestBody ParameterBody parameter) {
        try {
            return new ResponseEntity<>(wjService.createParameter(parameter), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/parameter-types/create")
    public ResponseEntity<Object> createParameterType(@Valid @RequestBody ParameterTypeBody parameterType) {
        return new ResponseEntity<>(wjService.createParameterType(parameterType), HttpStatus.CREATED);
    }

    @PostMapping("/users/create")
    public ResponseEntity<Object> createUser(@Valid @RequestBody UserBody user) {
        try {
            return new ResponseEntity<>(wjService.createUser(user), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/users/login")
    public ResponseEntity<Object> login() {
        return new ResponseEntity<>("Success!", HttpStatus.OK);
    }

    @PostMapping("/user-workouts/create")
    public ResponseEntity<Object> createUserWorkout(@Valid @RequestBody UserWorkoutBody userWorkout) {
        try {
            return new ResponseEntity<>(wjService.createUserWorkout(userWorkout), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/user-workout-parameter-values/create")
    public ResponseEntity<Object> createUserWorkoutParameterValue(@Valid @RequestBody UserWorkoutParameterValueBody userWorkoutParameterValue) {
        try {
            return new ResponseEntity<>(wjService.createUserWorkoutParameterValue(userWorkoutParameterValue), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/workouts/create")
    public ResponseEntity<Object> createWorkout(@Valid @RequestBody WorkoutBody workout) {
        return new ResponseEntity<>(wjService.createWorkout(workout), HttpStatus.CREATED);
    }

    @PostMapping("/workout-exercises/create")
    public ResponseEntity<Object> createWorkoutExercise(@Valid @RequestBody WorkoutExerciseBody workoutExercise) {
        try {
            return new ResponseEntity<>(wjService.createWorkoutExercise(workoutExercise), HttpStatus.CREATED);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/exercises/{id}")
    public ResponseEntity<Object> updateExercise(@Valid @RequestBody ExerciseBody exercise, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateExercise(exercise, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/exercise-parameters/{id}")
    public ResponseEntity<Object> updateExerciseParameter(@Valid @RequestBody ExerciseParameterBody exerciseParameter, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateExerciseParameter(exerciseParameter, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/exercise-types/{id}")
    public ResponseEntity<Object> updateExerciseType(@Valid @RequestBody ExerciseTypeBody exerciseType, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateExerciseType(exerciseType, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/measure-units/{id}")
    
    public ResponseEntity<Object> updateMeasureUnit(@Valid @RequestBody MeasureUnitBody measureUnit, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateMeasureUnit(measureUnit, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/parameters/{id}")
    public ResponseEntity<Object> updateParameter(@Valid @RequestBody ParameterBody parameter, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateParameter(parameter, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/parameter-types/{id}")
    public ResponseEntity<Object> updateParameterType(@Valid @RequestBody ParameterTypeBody parameterType, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateParameterType(parameterType, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<Object> updateUser(@Valid @RequestBody UserBody user, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateUser(user, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user-workouts/{id}")
    public ResponseEntity<Object> updateUserWorkout(@Valid @RequestBody UserWorkoutBody userWorkout, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateUserWorkout(userWorkout, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/user-workout-parameter-values/{id}")
    public ResponseEntity<Object> updateUserWorkoutParameterValue(@Valid @RequestBody UserWorkoutParameterValueBody userWorkoutParameterValue, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateUserWorkoutParameterValue(userWorkoutParameterValue, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/workouts/{id}")
    public ResponseEntity<Object> updateWorkout(@Valid @RequestBody WorkoutBody workout, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateWorkout(workout, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/workout-exercises/{id}")
    public ResponseEntity<Object> updateWorkoutExercise(@Valid @RequestBody WorkoutExerciseBody workoutExercise, @PathVariable(name = "id") long id) {
        try {
            return new ResponseEntity<>(wjService.updateWorkoutExercise(workoutExercise, id), HttpStatus.OK);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/exercises/{id}")
    public ResponseEntity<Object> deleteExercise(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteExercise(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/exercise-parameters/{id}")
    public ResponseEntity<Object> deleteExerciseParameter(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteExerciseParameter(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/exercise-types/{id}")
    public ResponseEntity<Object> deleteExerciseType(@PathVariable(name = "id") long id) {
      try {
          wjService.deleteExerciseType(id);
          return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/measure-units/{id}")
    public ResponseEntity<Object> deleteMeasureUnit(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteMeasureUnit(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/parameters/{id}")
    public ResponseEntity<Object> deleteParameter(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteParameter(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/parameter-types/{id}")
    public ResponseEntity<Object> deleteParameterType(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteParameterType(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<Object> deleteUser(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteUser(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/user-workouts/{id}")
    public ResponseEntity<Object> deleteUserWorkout(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteUserWorkout(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/user-workout-parameter-values/{id}")
    public ResponseEntity<Object> deleteUserWorkoutParameterValue(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteUserWorkoutParameterValue(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/workouts/{id}")
    public ResponseEntity<Object> deleteWorkout(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteWorkout(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (CustomException e) {
            return new ResponseEntity<>(e.errorBody(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/workout-exercises/{id}")
    public ResponseEntity<Object> deleteWorkoutExercise(@PathVariable(name = "id") long id) {
        try {
            wjService.deleteWorkoutExercise(id);
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
