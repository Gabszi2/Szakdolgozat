import {Component, OnInit} from '@angular/core';
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute, Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";


@Component({
  selector: 'app-admin-question-add',
  templateUrl: './admin-question-add.component.html',
  styleUrls: ['./admin-question-add.component.css']
})
export class AdminQuestionAddComponent implements OnInit {
  cuisine!: string;
  questionForm!: FormGroup;

  constructor(private service: AdminQuestionService, private route: ActivatedRoute, private router: Router, private formBuilder: FormBuilder) {
  }

  async ngOnInit() {
    this.cuisine = <string>this.route.snapshot.paramMap.get('cuisine');
    this.questionForm = this.formBuilder.group({
      question: ['', Validators.required]
    })
  }

  async questionAdd() {
    const question = this.questionForm.get('question')?.value;
    await this.service.addQuestion(this.cuisine, question);
    await this.router.navigate(['/admin/question-list/' + this.cuisine])
  }
}
