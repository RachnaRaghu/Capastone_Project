import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/services/admin-service/admin.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { UserService } from 'src/app/services/user-service/user-service.service';
import { UtilityService } from 'src/app/services/utility-service/utility-service.service';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  userForm: FormGroup;

  constructor(
    private router: Router,
    private formbuilder: FormBuilder,
    private userService: UserService,
    private utilityService: UtilityService
  ) { }

  ngOnInit() {
    this.formInitialize();
  }

  formInitialize() {
    this.userForm = this.formbuilder.group({
      userName: ['', [Validators.required]],
      emailId: ['', [Validators.required]],
      mobilenumber: ['', [Validators.required]],
      password: ['', [Validators.required]]
    });
  }

  createUser() {
    this.userService.createUser(this.userForm.value).subscribe((resp: any) => {
      if (resp.result) {
        this.utilityService.openSnackBar('User created Successfully', 'Ok');
        this.router.navigate(['/landing/listSurveys']);
      } else {
        this.utilityService.openSnackBar('Username already exists', 'Ok');
      }
      // this.router.navigate(['/landing/listSurveys']);
    });
  }

}
