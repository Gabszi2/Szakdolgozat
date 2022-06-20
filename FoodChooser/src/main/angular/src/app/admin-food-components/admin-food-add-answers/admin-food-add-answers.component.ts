import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup} from "@angular/forms";
import {AdminFoodService} from "../../services/admin-food.service";
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FoodModel} from "../../models/food-model";

@Component({
  selector: 'app-admin-food-add-answers',
  templateUrl: './admin-food-add-answers.component.html',
  styleUrls: ['./admin-food-add-answers.component.css']
})
export class AdminFoodAddAnswersComponent implements OnInit {
  town!:string;
  kitchen!:string;
  foodName!:string;
  food!:FoodModel;
  questions!:string[];



  answersForm=this.fb.group({
    answers:this.fb.array([])
  });

  answerForm():FormGroup{
    return this.fb.group({
      answer:''
    })
  };
  constructor(private fb:FormBuilder,private foodService:AdminFoodService,private questionService:AdminQuestionService,private route: ActivatedRoute,private router:Router) {
  }

  async ngOnInit(){
    this.town=<string>this.route.snapshot.paramMap.get('town');
    this.kitchen=<string>this.route.snapshot.paramMap.get('kitchen');
    this.foodName=<string>this.route.snapshot.paramMap.get('foodName');
    this.food=await this.foodService.getFood(this.town, this.kitchen, this.foodName);
    this.questions= await this.questionService.getAllQuestion(this.kitchen);
    for(let question in this.questions){
      this.addAnswer();
    }
  }
  get answers():FormArray{
    return this.answersForm.get("answers") as FormArray;
  }
  addAnswer(){
    this.answers.push(this.answerForm());
  }
  async done() {
let answers=[];
    for (let i =0;i< this.answers.length;i++) {
      const element = this.answers.at(i).get("answer")?.value;
      answers.push(element);
    }

this.food.answer=answers;

await this.foodService.updateFood(this.town,this.kitchen,this.food);
    await this.router.navigate(['/admin/food-add-restaurants/' + this.town+'/'+this.kitchen+'/'+this.foodName])
  }
}
