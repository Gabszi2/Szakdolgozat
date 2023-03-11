import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';

import {AppComponent} from './app.component';
import {RouterModule} from "@angular/router";
import {LoginComponent} from './login/login.component';
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
import {HTTP_INTERCEPTORS, HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {
  AdminFoodModifyAnswersComponent
} from './admin-food-components/admin-food-modify-answers/admin-food-modify-answers.component';
import {
  AdminFoodModifyRestaurantsComponent
} from './admin-food-components/admin-food-modify-restaurants/admin-food-modify-restaurants.component';
import {
  CustomerQuestionsFormComponent
} from './customer-components/customer-questions-form/customer-questions-form.component';
import {CustomerResultsComponent} from './customer-components/customer-results/customer-results.component';
import {CustomerStartComponent} from './customer-components/customer-start/customer-start.component';
import {RegisterComponent} from './register/register.component';
import {NavComponent} from './nav/nav.component';
import {AdminUsersComponent} from './admin-users/admin-users.component';
import {
  AdminRecommendationsComponent
} from './admin-recommendation-components/admin-recommendations/admin-recommendations.component';
import {
  AdminApprovedRecComponent
} from './admin-recommendation-components/admin-approved-rec/admin-approved-rec.component';
import {
  AdminRecommendationDetailsComponent
} from './admin-recommendation-components/admin-recommendation-details/admin-recommendation-details.component';
import {RecommendationComponent} from './customer-components/recommendation/recommendation.component';
import {AdminCityListComponent} from './admin-city-components/admin-city-list/admin-city-list.component';
import {AdminCityModifyComponent} from './admin-city-components/admin-city-modify/admin-city-modify.component';
import {AdminCityAddComponent} from './admin-city-components/admin-city-add/admin-city-add.component';
import {HttpErrorInterceptor} from "./http-error.interceptor";


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
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
    CustomerStartComponent,
    RegisterComponent,
    NavComponent,
    AdminUsersComponent,
    AdminRecommendationsComponent,
    AdminApprovedRecComponent,
    AdminRecommendationDetailsComponent,
    RecommendationComponent,
    AdminCityListComponent,
    AdminCityModifyComponent,
    AdminCityAddComponent
  ],
  imports: [
    BrowserModule,
    RouterModule,
    AppRoutingModule,
    HttpClientModule,
    ReactiveFormsModule,
    FormsModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: HttpErrorInterceptor,
    multi: true,
  }],
  bootstrap: [AppComponent]
})
export class AppModule {
}
