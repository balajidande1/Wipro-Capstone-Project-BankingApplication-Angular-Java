import { Component } from '@angular/core';
import { RouterOutlet, RouterModule } from '@angular/router';
import { HomeComponentComponent } from './home-component/home-component.component';






@Component({
  selector: 'app-root',
  imports: [RouterOutlet,HomeComponentComponent, RouterModule],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  title = 'Banking-Application Frontend';
}
