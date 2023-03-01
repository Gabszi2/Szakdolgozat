import {Component, OnInit} from '@angular/core';
import {AdminQuestionService} from "../../services/admin-question.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-admin-question-list',
  templateUrl: './admin-question-list.component.html',
  styleUrls: ['./admin-question-list.component.css']
})
export class AdminQuestionListComponent implements OnInit {
  questions!: string[];
  cuisine!: string;

  constructor(private service: AdminQuestionService, private route: ActivatedRoute) {
  }

  async ngOnInit() {
    this.cuisine = <string>this.route.snapshot.paramMap.get('cuisine');
    this.questions = await this.service.getAllQuestion(this.cuisine);
  }

  async deleteQuestion(question: string) {
    await this.service.deleteQuestion(this.cuisine, question);
    this.questions = await this.service.getAllQuestion(this.cuisine);
  }
}
