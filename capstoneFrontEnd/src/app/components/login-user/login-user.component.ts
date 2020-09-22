import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user-service/user-service.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';

@Component({
  selector: 'app-login-user',
  templateUrl: './login-user.component.html',
  styleUrls: ['./login-user.component.css']
})
export class LoginUserComponent implements OnInit {
  userName: string;
  password: string;
  showError = false;
  logInForm: FormGroup;

  constructor(
    private router: Router,
    private userService: UserService,
    private formBuilder: FormBuilder
  ) { }

  ngOnInit() {
    this.formInitialize();
  }

  formInitialize() {
    this.logInForm = this.formBuilder.group({
      userName: ['', [Validators.required]],
      password: ['', Validators.required]
    });
  }

  login() {
    this.userService.login(this.logInForm.value).subscribe((resp: any) => {
      if (resp.result) {
        localStorage.setItem('isLoggedIn', 'true');
        this.router.navigate(['/landing/listSurveys']);
      } else {
        this.showError = true;
      }
    });
  }
}

