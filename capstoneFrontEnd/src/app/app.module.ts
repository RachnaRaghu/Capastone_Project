import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LandingComponent } from './components/landing/landing.component';
import { LoginComponent } from './components/login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatSnackBarModule } from '@angular/material';
import { TakeSurveyComponent } from './components/take-survey/take-survey.component';
import { ListSurveysComponent } from './components/list-surveys/list-surveys.component';
import { SurveyRendererComponent } from './components/survey-renderer/survey-renderer.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { LoginUserComponent } from './components/login-user/login-user.component';
import { LandingUserComponent } from './components/landing-user/landing-user.component';

@NgModule({
  declarations: [
    AppComponent,
    LandingComponent,
    LoginComponent,
    TakeSurveyComponent,
    ListSurveysComponent,
    SurveyRendererComponent,
    RegistrationComponent,
    LoginUserComponent,
    LandingUserComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSnackBarModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
