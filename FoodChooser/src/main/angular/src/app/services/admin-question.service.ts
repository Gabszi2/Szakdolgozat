import {Injectable} from '@angular/core';
import {HttpClient, HttpParams} from "@angular/common/http";

import {QuestionSaveModel} from "../models/question-save-model";
import {lastValueFrom} from "rxjs";
import {CityModel} from "../models/city-model";


@Injectable({
  providedIn: 'root'
})
export class AdminQuestionService {

  adminUrl: string;

  constructor(private http: HttpClient) {
    this.adminUrl = 'http://localhost:8080/admin'
  }

  async getAllQuestion(cuisine: string) {
    return lastValueFrom(this.http.get<string[]>(this.adminUrl + '/questions/' + cuisine));
  }

  async deleteQuestion(cuisine: string, question: string) {
    let httpParams = new HttpParams().set('question', question);
    let options = {params: httpParams};
    return lastValueFrom(this.http.delete(this.adminUrl + '/question/' + cuisine, options));
  }

  async addQuestion(cuisine: string, question: string) {
    let httpParams = new HttpParams().set('question', question);
    return lastValueFrom(this.http.post(this.adminUrl + '/question/' + cuisine, null, {
      params: httpParams,
      responseType: "text"
    }));
  }

  async updateQuestion(cuisine: string, questionSave: QuestionSaveModel) {
    return lastValueFrom(this.http.put(this.adminUrl + '/question/' + cuisine, questionSave));
  }

  async getCities() {
    return lastValueFrom(this.http.get<CityModel[]>(this.adminUrl + '/cities'));
  }
}
