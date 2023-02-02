import {Component, OnInit} from '@angular/core';
import {FoodModel} from "../../models/food-model";
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdminFoodService} from "../../services/admin-food.service";
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-admin-food-modify-answers',
  templateUrl: './admin-food-modify-answers.component.html',
  styleUrls: ['./admin-food-modify-answers.component.css']
})
export class AdminFoodModifyAnswersComponent implements OnInit {
  town!: string;
  kitchen!: string;
  foodName!: string;
  food!: FoodModel;
  questions!: string[];

  answersForm = this.fb.group({
    answers: this.fb.array([])
  });

  constructor(private fb: FormBuilder, private foodService: AdminFoodService, private questionService: AdminQuestionService, private route: ActivatedRoute, private router: Router) {
  }

  get answers(): FormArray {
    return this.answersForm.get("answers") as FormArray;
  }

  answerForm(): FormGroup {
    return this.fb.group({
      answer: ['', Validators.required]
    })
  };

  async ngOnInit() {
    this.town = <string>this.route.snapshot.paramMap.get('town');
    this.kitchen = <string>this.route.snapshot.paramMap.get('kitchen');
    this.foodName = <string>this.route.snapshot.paramMap.get('foodName');
    this.food = await this.foodService.getFood(this.town, this.kitchen, this.foodName);
    this.questions = await this.questionService.getAllQuestion(this.kitchen);
    for (let question in this.questions) {
      this.addAnswer();
    }
    for (let i = 0; i < this.answers.length; i++) {
      this.answers.at(i).get("answer")?.setValue(this.food.answer[i]);

    }
  }

  addAnswer() {
    this.answers.push(this.answerForm());
  }

  async done() {
    let answers = [];
    for (let i = 0; i < this.answers.length; i++) {
      const element = this.answers.at(i).get("answer")?.value;
      answers.push(element);
    }

    this.food.answer = answers;

    await this.foodService.updateFood(this.town, this.kitchen, this.food);
    await this.router.navigate(['/admin/food-list/' + this.town + '/' + this.kitchen])
  }
}
