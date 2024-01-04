import { TableModule } from 'primeng/table';
import {  DialogModule } from 'primeng/dialog';
import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DropdownModule } from 'primeng/dropdown';
import { MenubarModule } from 'primeng/menubar';
import { ButtonModule } from 'primeng/button';
import { ListboxModule } from 'primeng/listbox';
import { RadioButtonModule } from 'primeng/radiobutton';
import { PanelModule } from 'primeng/panel';
import { CalendarModule } from 'primeng/calendar';
import { AccordionModule } from 'primeng/accordion';
import { TabViewModule } from 'primeng/tabview';
import { FocusTrapModule } from 'primeng/focustrap';
import { CheckboxModule } from 'primeng/checkbox';
import { TreeTableModule } from 'primeng/treetable';
import { TreeModule } from 'primeng/tree';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';

const ANGULAR_MODULES = [
	FormsModule
]

const APP_PRIMENG_MODULE = [
	TableModule,
	DialogModule,
	ConfirmDialogModule,
	DropdownModule,
	MenubarModule,
	ButtonModule,
	ListboxModule,
	RadioButtonModule,
	PanelModule,
	AccordionModule,
	CalendarModule,
	TabViewModule,
	FocusTrapModule,
	CheckboxModule,
	TreeTableModule,
	TreeModule,
	ButtonModule,
	 DropdownModule
]

@NgModule({
	imports: [
		APP_PRIMENG_MODULE,
		ANGULAR_MODULES
	],
	exports: [
		APP_PRIMENG_MODULE,
		ANGULAR_MODULES
	],
	declarations:[

	]
})

export class SharedModule{

}