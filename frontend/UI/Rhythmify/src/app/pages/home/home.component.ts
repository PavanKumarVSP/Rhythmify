import { Component ,OnInit} from '@angular/core';
import { AuthService } from '../../services/auth.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  public currentUser:any|null=null;

  constructor(private authService:AuthService){}
  ngOnInit(): void {
    this.currentUser = this.authService.getUser();
    console.log('Current User:', this.currentUser);
  }
  

}
