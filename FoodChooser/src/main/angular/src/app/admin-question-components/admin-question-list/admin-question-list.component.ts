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
  kitchen!: string;

  constructor(private service: AdminQuestionService, private route: ActivatedRoute) {
  }

  async ngOnInit() {
    this.kitchen = <string>this.route.snapshot.paramMap.get('kitchen');
    this.questions = await this.service.getAllQuestion(this.kitchen);
  }

  async deleteQuestion(question: string) {
    await this.service.deleteQuestion(this.kitchen, question);
    this.questions = await this.service.getAllQuestion(this.kitchen);
  }
}
