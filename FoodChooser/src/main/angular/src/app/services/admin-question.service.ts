import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";

import {QuestionSaveModel} from "../models/question-save-model";


@Injectable({
  providedIn: 'root'
})
export class AdminQuestionService {

  adminUrl: string;

  constructor(private http: HttpClient) {
    this.adminUrl = 'http://localhost:8080/admin'
  }

  getAllFood(kitchen: string) {
    return this.http.get<String[]>(this.adminUrl + '/questions/' + kitchen);
  }

  deleteFood(kitchen: string, question: string) {
    this.http.request('delete', this.adminUrl + '/question/' + kitchen, {body: question});
  }

  addFood(kitchen: string, question: string) {

    return this.http.post(this.adminUrl + '/question/' + kitchen, question);
  }

  updateFood(kitchen: string, questionSave: QuestionSaveModel) {
    return this.http.post<String>(this.adminUrl + '/question/' + kitchen, questionSave);
  }
}
