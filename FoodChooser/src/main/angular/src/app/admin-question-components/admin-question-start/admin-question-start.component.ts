import {Component, OnInit} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-question-start',
  templateUrl: './admin-question-start.component.html',
  styleUrls: ['./admin-question-start.component.css']
})
export class AdminQuestionStartComponent implements OnInit {
  selectedKitchen!:string;
  kitchens:string[]=['asian','turkish'];
  constructor() {
  }

  ngOnInit(): void {
  }

}
