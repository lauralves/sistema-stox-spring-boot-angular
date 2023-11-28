import {Component, Injector} from '@angular/core';
import {Location} from "@angular/common";

@Component({
  selector: 'app-produto-edit',
  templateUrl: './produto-dialog.component.html',
  styleUrls: ['./produto-dialog.component.scss']
})
export class ProdutoDialogComponent {
  private location: Location;
  constructor(private injector: Injector) {

    this.location = injector.get(Location);
  }

  back(){
    this.location.back()
  }
}
