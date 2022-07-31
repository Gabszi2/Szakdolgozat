import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {RouterModule} from "@angular/router";
import {StartPageComponent} from './start-page/start-page.component';
import {AdminChoiceComponent} from './admin-choice/admin-choice.component';
import {AdminFoodStartComponent} from './admin-food-components/admin-food-start/admin-food-start.component';
import {AdminFoodListComponent} from './admin-food-components/admin-food-list/admin-food-list.component';
import {AdminFoodAddComponent} from './admin-food-components/admin-food-add/admin-food-add.component';
import {AdminFoodModifyComponent} from './admin-food-components/admin-food-modify/admin-food-modify.component';
import {
  AdminQuestionModifyComponent
} from './admin-question-components/admin-question-modify/admin-question-modify.component';
import {AdminQuestionAddComponent} from './admin-question-components/admin-question-add/admin-question-add.component';
import {
  AdminQuestionListComponent
} from './admin-question-components/admin-question-list/admin-question-list.component';
import {
  AdminQuestionStartComponent
} from './admin-question-components/admin-question-start/admin-question-start.component';
import {AppRoutingModule} from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import { AdminFoodModifyAnswersComponent } from './admin-food-components/admin-food-modify-answers/admin-food-modify-answers.component';
import { AdminFoodModifyRestaurantsComponent } from './admin-food-components/admin-food-modify-restaurants/admin-food-modify-restaurants.component';
import { CustomerQuestionsFormComponent } from './customer/customer-questions-form/customer-questions-form.component';
import { CustomerResultsComponent } from './customer/customer-results/customer-results.component';
import { CustomerStartComponent } from './customer/customer-start/customer-start.component';


@NgModule({
  declarations: [
    AppComponent,
    StartPageComponent,
    AdminChoiceComponent,
    AdminFoodStartComponent,
    AdminFoodListComponent,
    AdminFoodAddComponent,
    AdminFoodModifyComponent,
    AdminQuestionModifyComponent,
    AdminQuestionAddComponent,
    AdminQuestionListComponent,
    AdminQuestionStartComponent,
    AdminFoodModifyAnswersComponent,
    AdminFoodModifyRestaurantsComponent,
    CustomerQuestionsFormComponent,
    CustomerResultsComponent,
    CustomerStartComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
