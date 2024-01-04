import { CUSTOM_ELEMENTS_SCHEMA, Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { MessageService } from "primeng/api";
import { ButtonModule } from 'primeng/button';
import { DialogService, DynamicDialogConfig, DynamicDialogRef } from "primeng/dynamicdialog";
import { FornecedorListView } from "../../../domain/fornecedor-list-view";
import { SharedModule } from '../../../provides/shared.module';
import { FornecedorService } from "../../../service/fornecedor.service";

@Component({
  selector: 'app-fornecedor-dialog',
  templateUrl: './fornecedor-dialog.component.html',
  styleUrls: ['./fornecedor-dialog.component.scss'],
  providers: [SharedModule],
  standalone: true,
  schemas: [CUSTOM_ELEMENTS_SCHEMA],
  imports: [FormsModule, ButtonModule]
})
export class FornecedorDialogComponent implements OnInit {

  fornecedor: FornecedorListView;

  constructor(public ref: DynamicDialogRef, private fornecedorService: FornecedorService, private messageService: MessageService,
    private dialogService: DialogService,
    private data: FornecedorListView,
    public config: DynamicDialogConfig
  ) {

    this.fornecedor = data;
  }
  ngOnInit() {
    if (this.config.data) {
      this.fornecedor = this.config.data
    }
  }

  save() {
    this.fornecedorService.save(this.fornecedor).subscribe(
      (resource: FornecedorListView) => {
          this.ref.close(resource)
      },
    )
  }
  
  back() {
    this.ref.close();
  }

  reload() {
    window.location.reload();

  }
}
