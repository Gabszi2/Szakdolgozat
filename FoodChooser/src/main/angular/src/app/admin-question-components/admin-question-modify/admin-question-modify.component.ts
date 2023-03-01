import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {QuestionSaveModel} from "../../models/question-save-model";

@Component({
  selector: 'app-admin-question-modify',
  templateUrl: './admin-question-modify.component.html',
  styleUrls: ['./admin-question-modify.component.css']
})
export class AdminQuestionModifyComponent implements OnInit {
  cuisine!: string;
  oldQuestion!: string;
  questionForm!: FormGroup;

  constructor(private service: AdminQuestionService, private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.cuisine = <string>this.route.snapshot.paramMap.get('cuisine');
    this.oldQuestion = <string>this.route.snapshot.paramMap.get('question')
    this.questionForm = this.formBuilder.group({
      question: ['', Validators.required]
    })
  }

  async questionModify() {
    const newQuestion = this.questionForm.get('question')?.value;
    const questionUpdate = <QuestionSaveModel>{};
    questionUpdate.oldQuestion = this.oldQuestion;
    questionUpdate.newQuestion = newQuestion;
    await this.service.updateQuestion(this.cuisine, questionUpdate);
    await this.router.navigate(['/admin/question-list/' + this.cuisine])
  }
}
