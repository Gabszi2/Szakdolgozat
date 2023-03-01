import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdminFoodService} from "../../services/admin-food.service";
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FoodModel} from "../../models/food-model";

@Component({
  selector: 'app-admin-food-add',
  templateUrl: './admin-food-add.component.html',
  styleUrls: ['./admin-food-add.component.css']
})
export class AdminFoodAddComponent implements OnInit {
  town!: string;
  cuisine!: string;
  questions!: string[];

  foodForm = this.formBuilder.group({
    foodName: ['', Validators.required],
    foodAnswers: this.formBuilder.array([]),
    foodRestaurants: this.formBuilder.array([])
  });

  constructor(private foodService: AdminFoodService, private route: ActivatedRoute, private formBuilder: FormBuilder, private router: Router, private questionService: AdminQuestionService) {
  }

  get foodRestaurants(): FormArray {
    return this.foodForm.get("foodRestaurants") as FormArray;
  }

  get foodAnswers(): FormArray {
    return this.foodForm.get("foodAnswers") as FormArray;
  }

  answerForm(): FormGroup {
    return this.formBuilder.group({
      foodAnswer: ['', Validators.required]
    })
  };

  restaurantForm(): FormGroup {
    return this.formBuilder.group({
      foodRestaurant: ['', Validators.required]
    })
  };

  async ngOnInit() {
    this.town = <string>this.route.snapshot.paramMap.get('town');
    this.cuisine = <string>this.route.snapshot.paramMap.get('cuisine');
    this.questions = await this.questionService.getAllQuestion(this.cuisine);
    for (let question in this.questions) {
      this.addAnswer();
    }
  }

  addRestaurant() {
    this.foodRestaurants.push(this.restaurantForm());
  }

  addAnswer() {
    this.foodAnswers.push(this.answerForm());
  }

  delete(index: number) {
    this.foodRestaurants.removeAt(index);
  }

  async foodAdd() {
    const name = this.foodForm.get('foodName')?.value;

    let answers = [];
    for (let i = 0; i < this.foodAnswers.length; i++) {
      const element = this.foodAnswers.at(i).get("foodAnswer")?.value;
      answers.push(element);
    }

    let restaurants = [];
    for (let i = 0; i < this.foodRestaurants.length; i++) {
      const element = this.foodRestaurants.at(i).get("foodRestaurant")?.value;
      restaurants.push(element);
    }
    const food = <FoodModel>{};
    food.foodName = name;
    food.answer = answers;
    food.restaurants = restaurants;

    await this.foodService.addFood(this.town, this.cuisine, food)
    await this.router.navigate(['/admin/food-list/' + this.town + '/' + this.cuisine])

  }
}
