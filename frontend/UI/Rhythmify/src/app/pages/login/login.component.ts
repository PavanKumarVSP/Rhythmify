import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AuthService, LoginRequest } from '../../services/auth.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  email:string='';
  password:string='';
  name:string='';

  request:LoginRequest={
    userEmail:this.email,
    userPassword:this.password,
    userName:this.name
  }


  constructor(private authService:AuthService){}


  onLogin(){
    



this.authService.login(this.request).subscribe(
      {
        next:(response) => {
          console.log("Success response",response);
        },
        error:(response)=>{
          console.log("Error response ", response);
        }
        
      }
    )


  }


}
  

