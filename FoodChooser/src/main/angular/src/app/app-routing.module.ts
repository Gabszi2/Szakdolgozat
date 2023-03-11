import {NgModule} from '@angular/core';
import {RouterModule, Routes} from '@angular/router';
import {LoginComponent} from "./login/login.component";
import {AdminChoiceComponent} from "./admin-choice/admin-choice.component";
import {AdminFoodStartComponent} from "./admin-food-components/admin-food-start/admin-food-start.component";
import {
  AdminQuestionStartComponent
} from "./admin-question-components/admin-question-start/admin-question-start.component";
import {
  AdminQuestionListComponent
} from "./admin-question-components/admin-question-list/admin-question-list.component";
import {AdminQuestionAddComponent} from "./admin-question-components/admin-question-add/admin-question-add.component";
import {
  AdminQuestionModifyComponent
} from "./admin-question-components/admin-question-modify/admin-question-modify.component";
import {AdminFoodListComponent} from "./admin-food-components/admin-food-list/admin-food-list.component";
import {AdminFoodModifyComponent} from "./admin-food-components/admin-food-modify/admin-food-modify.component";
import {AdminFoodAddComponent} from "./admin-food-components/admin-food-add/admin-food-add.component";
import {
  AdminFoodModifyAnswersComponent
} from "./admin-food-components/admin-food-modify-answers/admin-food-modify-answers.component";
import {
  AdminFoodModifyRestaurantsComponent
} from "./admin-food-components/admin-food-modify-restaurants/admin-food-modify-restaurants.component";
import {
  CustomerQuestionsFormComponent
} from "./customer-components/customer-questions-form/customer-questions-form.component";
import {CustomerResultsComponent} from "./customer-components/customer-results/customer-results.component";
import {CustomerStartComponent} from "./customer-components/customer-start/customer-start.component";
import {RegisterComponent} from "./register/register.component";
import {AdminGuard} from "./admin.guard";
import {UserGuard} from "./user.guard";
import {AdminUsersComponent} from "./admin-users/admin-users.component";
import {
  AdminRecommendationsComponent
} from "./admin-recommendation-components/admin-recommendations/admin-recommendations.component";
import {
  AdminApprovedRecComponent
} from "./admin-recommendation-components/admin-approved-rec/admin-approved-rec.component";
import {
  AdminRecommendationDetailsComponent
} from "./admin-recommendation-components/admin-recommendation-details/admin-recommendation-details.component";
import {RecommendationComponent} from "./customer-components/recommendation/recommendation.component";
import {AdminCityListComponent} from "./admin-city-components/admin-city-list/admin-city-list.component";
import {AdminCityModifyComponent} from "./admin-city-components/admin-city-modify/admin-city-modify.component";
import {AdminCityAddComponent} from "./admin-city-components/admin-city-add/admin-city-add.component";


const routes: Routes = [
  //login/register-components
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},

  //admin-components
  {path: 'admin', component: AdminChoiceComponent, canActivate: [AdminGuard]},

  //question-components
  {path: 'admin/question-start', component: AdminQuestionStartComponent, canActivate: [AdminGuard]},
  {path: 'admin/question-list/:cuisine', component: AdminQuestionListComponent, canActivate: [AdminGuard]},
  {path: 'admin/question-add/:cuisine', component: AdminQuestionAddComponent, canActivate: [AdminGuard]},
  {
    path: 'admin/question-modify/:cuisine/:question',
    component: AdminQuestionModifyComponent,
    canActivate: [AdminGuard]
  },
  //food-components
  {path: 'admin/food-start', component: AdminFoodStartComponent, canActivate: [AdminGuard]},
  {path: 'admin/food-list/:town/:cuisine', component: AdminFoodListComponent, canActivate: [AdminGuard]},
  {path: 'admin/food-modify/:town/:cuisine/:foodName', component: AdminFoodModifyComponent, canActivate: [AdminGuard]},
  {path: 'admin/food-add/:town/:cuisine', component: AdminFoodAddComponent, canActivate: [AdminGuard]},
  {
    path: 'admin/food-modify-answers/:town/:cuisine/:foodName',
    component: AdminFoodModifyAnswersComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'admin/food-modify-restaurants/:town/:cuisine/:foodName',
    component: AdminFoodModifyRestaurantsComponent,
    canActivate: [AdminGuard]
  },
  //user-components
  {path: 'admin/users', component: AdminUsersComponent, canActivate: [AdminGuard]},
  //recommendation-components
  {path: 'admin/recommendations', component: AdminRecommendationsComponent, canActivate: [AdminGuard]},
  {path: 'admin/approved-recommendations', component: AdminApprovedRecComponent, canActivate: [AdminGuard]},
  {path: 'admin/recommendation/:id', component: AdminRecommendationDetailsComponent, canActivate: [AdminGuard]},
  //city-components
  {path: 'admin/cities', component: AdminCityListComponent, canActivate: [AdminGuard]},
  {path: 'admin/city-modify/:town', component: AdminCityModifyComponent, canActivate: [AdminGuard]},
  {path: 'admin/city-add', component: AdminCityAddComponent, canActivate: [AdminGuard]},
  //customer-components
  {path: 'start', component: CustomerStartComponent, canActivate: [UserGuard]},
  {path: 'question-form/:town/:cuisine', component: CustomerQuestionsFormComponent, canActivate: [UserGuard]},
  {path: 'results/:town/:cuisine/:answers', component: CustomerResultsComponent, canActivate: [UserGuard]},
  {path: 'recommendation', component: RecommendationComponent, canActivate: [UserGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
