import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdminFoodService} from "../../services/admin-food.service";
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-admin-food-add',
  templateUrl: './admin-food-add.component.html',
  styleUrls: ['./admin-food-add.component.css']
})
export class AdminFoodAddComponent implements OnInit {
  town!:string;
  kitchen!:string;
questions!:string[];
questionAnswers!:boolean[];

answersForm=this.fb.group({
  answers:this.fb.array([])
});

  answerForm():FormGroup{
    return this.fb.group({
      answer:''
    })
  };
  constructor(private fb:FormBuilder,private foodService:AdminFoodService,private questionService:AdminQuestionService,private route: ActivatedRoute) {
  }

  async ngOnInit(){
    this.town=<string>this.route.snapshot.paramMap.get('town');
    this.kitchen=<string>this.route.snapshot.paramMap.get('kitchen');
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
done() {

}
}
