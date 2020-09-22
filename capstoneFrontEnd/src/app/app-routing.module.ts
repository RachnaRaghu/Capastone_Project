import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { LoginComponent } from './components/login/login.component';
import { LandingComponent } from './components/landing/landing.component';
import { TakeSurveyComponent } from './components/take-survey/take-survey.component';
import { ListSurveysComponent } from './components/list-surveys/list-surveys.component';
import { CanDeactivateRouteGuard } from './services/auth-guard/can-deactivate-route-guard.service';
import { CanActivateRouteGuard } from './services/auth-guard/can-activate-route-guard.service';
import { RegistrationComponent } from './components/registration/registration.component';
import { LandingUserComponent } from './components/landing-user/landing-user.component';
const routes: Routes = [
  {
    path: 'landing', component: LandingComponent,
    children: [
      { path: 'landing', redirectTo: 'listSurveys', pathMatch: 'full' },
      { path: 'login', component: LoginComponent },
      { path: 'listSurveys', component: ListSurveysComponent },
      { path: 'takeSurvey/:survyeId', component: TakeSurveyComponent, canDeactivate: [CanDeactivateRouteGuard] }
    ]
  },
  {
    path: '', component: LandingUserComponent,
    children: [
      { path: '', redirectTo: 'loginuser', pathMatch: 'full' },
      { path: 'loginuser', component: LoginUserComponent },
      { path: 'registration', component: RegistrationComponent }
    ]


  },
  {
    path: 'admin', loadChildren: './modules/admin/admin.module#AdminModule', canActivate: [CanActivateRouteGuard]
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
