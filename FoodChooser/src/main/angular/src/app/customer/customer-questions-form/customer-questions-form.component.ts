import { Component, OnInit } from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdminFoodService} from "../../services/admin-food.service";
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FoodModel} from "../../models/food-model";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customer-questions-form',
  templateUrl: './customer-questions-form.component.html',
  styleUrls: ['./customer-questions-form.component.css']
})
export class CustomerQuestionsFormComponent implements OnInit {
  town!:string;
  kitchen!:string;


  questions!:string[];

  answersForm=this.fb.group({
    answers:this.fb.array([])
  });

  answerForm():FormGroup{
    return this.fb.group({
      answer:['',Validators.required]
    })
  };

  constructor(private fb:FormBuilder,private service:CustomerService,private route: ActivatedRoute,private router:Router) { }

 async ngOnInit(){
    this.town = <string>this.route.snapshot.paramMap.get('town');
    this.kitchen = <string>this.route.snapshot.paramMap.get('kitchen');

    this.questions = await this.service.getQuestions(this.kitchen);
    for (let question in this.questions) {
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




   await this.router.navigate(['/results/' + this.town+'/'+this.kitchen+'/'+JSON.stringify(answers)])
  }
}
