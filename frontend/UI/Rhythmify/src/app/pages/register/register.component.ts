import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { AuthService, RegisterRequest,userObject } from '../../services/auth.service';
import {  Router } from '@angular/router';




@Component({
  selector: 'app-register',
  standalone: true,
  imports: [CommonModule,FormsModule],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})



export class RegisterComponent {

  email:string='';
  password:string='';
  fullName:string='';
  mobileNumber:string='';
  errorMessage:string='';

  request:RegisterRequest={
    userEmail:this.email,
    userName:this.fullName,
    userPassword:this.password,
    userMobileNumber:this.mobileNumber
  }

  constructor(private authService:AuthService,private route:Router){}


  onRegister(){
    console.log(" inside onRegister method ");
    console.log("User Entered Email ",this.email.valueOf());
    console.log("User Entered Password ",this.password);
    console.log("User Entered FullName ",this.fullName);
    console.log("User Entered MobileNumber ",this.mobileNumber);
    
    this.request.userEmail=this.email;
    this.request.userPassword=this.password;
    this.request.userName=this.fullName;
    this.request.userMobileNumber=this.mobileNumber;

    this.authService.register(this.request).subscribe(
      {
        next:(response) => {
          console.log("Success response",response);
          this.errorMessage='';
          var userId=response.userId;

          const userObj:userObject={
            userEmail:this.email,
            userName:this.fullName,
            userPassword:this.password,
            userMobileNumber:this.mobileNumber,
            userId:userId
          }

          this.authService.setUser(userObj);
          this.route.navigate(['/home']);

        },
        error:(response)=>{
          console.log("Error response ", response.error.message);
          if(response && response.error){
            var error=response.error;
            this.errorMessage=error.message;
          }
        }
        
      }
    )


  }


}
