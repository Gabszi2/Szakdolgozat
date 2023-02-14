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
import {AdminRecommendationsComponent} from "./admin-recommendation-components/admin-recommendations/admin-recommendations.component";
import {AdminApprovedRecComponent} from "./admin-recommendation-components/admin-approved-rec/admin-approved-rec.component";
import {
  AdminRecommendationDetailsComponent
} from "./admin-recommendation-components/admin-recommendation-details/admin-recommendation-details.component";
import {RecommendationComponent} from "./customer-components/recommendation/recommendation.component";


const routes: Routes = [
  {path: '', redirectTo: '/login', pathMatch: 'full'},
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegisterComponent},
  //admin
  {path: 'admin', component: AdminChoiceComponent, canActivate: [AdminGuard]},//TODO nem szükséges?
  {path: 'admin/food-start', component: AdminFoodStartComponent, canActivate: [AdminGuard]},
  {path: 'admin/question-start', component: AdminQuestionStartComponent, canActivate: [AdminGuard]},
  {path: 'admin/question-list/:kitchen', component: AdminQuestionListComponent, canActivate: [AdminGuard]},
  {path: 'admin/question-add/:kitchen', component: AdminQuestionAddComponent, canActivate: [AdminGuard]},
  {
    path: 'admin/question-modify/:kitchen/:question',
    component: AdminQuestionModifyComponent,
    canActivate: [AdminGuard]
  },
  {path: 'admin/food-list/:town/:kitchen', component: AdminFoodListComponent, canActivate: [AdminGuard]},
  {path: 'admin/food-modify/:town/:kitchen/:foodName', component: AdminFoodModifyComponent, canActivate: [AdminGuard]},
  {path: 'admin/food-add/:town/:kitchen', component: AdminFoodAddComponent, canActivate: [AdminGuard]},
  {
    path: 'admin/food-modify-answers/:town/:kitchen/:foodName',
    component: AdminFoodModifyAnswersComponent,
    canActivate: [AdminGuard]
  },
  {
    path: 'admin/food-modify-restaurants/:town/:kitchen/:foodName',
    component: AdminFoodModifyRestaurantsComponent,
    canActivate: [AdminGuard]
  },
  {path: 'admin/users', component: AdminUsersComponent, canActivate: [AdminGuard]},
  {path: 'admin/recommendations', component: AdminRecommendationsComponent, canActivate: [AdminGuard]},
  {path:'admin/approved-recommendations',component:AdminApprovedRecComponent,canActivate:[AdminGuard]},
  {path:'admin/recommendation/:id',component:AdminRecommendationDetailsComponent,canActivate:[AdminGuard]},
  //customer-components
  {path: 'start', component: CustomerStartComponent, canActivate: [UserGuard]},
  {path: 'question-form/:town/:kitchen', component: CustomerQuestionsFormComponent, canActivate: [UserGuard]},
  {path: 'results/:town/:kitchen/:answers', component: CustomerResultsComponent, canActivate: [UserGuard]},
  {path:'recommendation',component:RecommendationComponent,canActivate:[UserGuard]}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
