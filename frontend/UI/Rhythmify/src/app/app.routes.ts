import { Routes } from '@angular/router';
import { LoginComponent } from './pages/login/login.component';
import { RegisterComponent } from './pages/register/register.component';
import { HomeComponent } from './pages/home/home.component';
import { AuthLayoutComponent } from './layouts/auth-layout/auth-layout.component';
import { MainLayoutComponent } from './layouts/main-layout/main-layout.component';

export const routes: Routes = [
  {
    path: '',
    component: AuthLayoutComponent,
    children: [
      { path: 'login', component: LoginComponent },
      { path: 'signup', component: RegisterComponent },
    ]
  },
  {
    path: '',
    component: MainLayoutComponent,
    children: [
      { path: 'home', component: HomeComponent },
      //{ path: 'playlists', component: PlaylistsComponent },
      //{ path: 'groups', component: GroupsComponent },
      //{ path: 'chat', component: ChatComponent },
      //{ path: 'profile', component: ProfileComponent },
    ]
  },
  { path: '**', redirectTo: 'login' } // fallback
];

