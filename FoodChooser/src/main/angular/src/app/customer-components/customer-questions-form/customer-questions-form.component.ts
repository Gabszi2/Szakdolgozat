import {Component, OnInit} from '@angular/core';
import {FormArray, FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {CustomerService} from "../../services/customer.service";

@Component({
  selector: 'app-customer-components-questions-form',
  templateUrl: './customer-questions-form.component.html',
  styleUrls: ['./customer-questions-form.component.css']
})
export class CustomerQuestionsFormComponent implements OnInit {
  town!: string;
  cuisine!: string;


  questions!: string[];

  answersForm = this.fb.group({
    answers: this.fb.array([])
  });

  constructor(private fb: FormBuilder, private service: CustomerService, private route: ActivatedRoute, private router: Router) {
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
    this.cuisine = <string>this.route.snapshot.paramMap.get('cuisine');

    this.questions = await this.service.getQuestions(this.cuisine);
    for (let question in this.questions) {
      this.addAnswer();
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


    await this.router.navigate(['/results/' + this.town + '/' + this.cuisine + '/' + JSON.stringify(answers)])
  }
}
