import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { AuthService } from '../services/auth.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  errorMessage !: string;
  formLogin! : FormGroup;
 
  protected submitted = false;
  constructor(private formBuilder : FormBuilder,
              private  authService : AuthService,
              private router : Router ){
  }

  ngOnInit(): void {
    this.formLogin = this.formBuilder.group({
      username : this.formBuilder.control("" , [
        Validators.required ,Validators.minLength(3)
      ]),
      password : this.formBuilder.control("", [
        Validators.required ,Validators.minLength(6)
      ])
    })
  }
  
  get f()
{
    return this.formLogin.controls;
}
  handleLogin(){
    //console.log(this.formLogin.value);
    this.submitted = true;
    let username = this.formLogin.value.username;
    let pwd = this.formLogin.value.password;
    this.authService.login(username,pwd).subscribe({
      next : data => {
        console.log(data)
        this.authService.loadProfil(data);
        this.router.navigateByUrl("/admin");
      },
      error : err => {
        console.log(err);
        this.errorMessage = 'error :  Username or password is incorrect'
      }

    })
  }

  handleRegister(){
    this.router.navigateByUrl(`/register`);
  }

}
