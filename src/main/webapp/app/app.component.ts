import { Component } from '@angular/core';
import { RouterLink, RouterLinkWithHref, RouterOutlet } from '@angular/router';
import { APP_PRIMENG_MODULE } from './provides/app-primeng-module';
import { ButtonModule } from 'primeng/button';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss'],
  standalone: true,
  imports: [RouterOutlet, RouterLink, RouterLinkWithHref],

})
export class AppComponent {
  title = 'itemflow';
}
