import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HttpClientModule } from '@angular/common/http';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { FormCourseComponent } from './components/form-course/form-course.component';
import { GridModule } from '@progress/kendo-angular-grid';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ProfessorListComponent } from './components/professor-list/professor-list.component';
import { StudentListComponent } from './components/student-list/student-list.component';
import { StudentFormComponent } from './components/student-form/student-form.component';
import { ProfessorFormComponent } from './components/professor-form/professor-form.component';
import { ButtonsModule } from '@progress/kendo-angular-buttons';
import { LabelModule } from '@progress/kendo-angular-label';
import { MenuModule } from '@progress/kendo-angular-menu';

//import { ConfirmationPopoverModule } from 'angular-confirmation-popover';

//import { DialogsModule } from '@progress/kendo-angular-dialog';

import { DropDownsModule } from '@progress/kendo-angular-dropdowns';
import { InputsModule } from '@progress/kendo-angular-inputs';
import { DialogsModule } from '@progress/kendo-angular-dialog';
import { ListCourseComponent } from './components/list-course/list-course.component';
import { UpdateCourseComponent } from './components/update-course/update-course.component';


const appRoutes: Routes = [
  {
    path: 'form-course',
    component: FormCourseComponent,
    data: { title: 'Course Add' }
  },
  {
    path: 'list-course',
    component: ListCourseComponent,
    data: { title: 'List Course' }
  },
  {
    path: 'professor-list',
    component: ProfessorListComponent,
    data: { title: 'Professor List' }
  }, {
    path: 'professor-add',
    component: ProfessorFormComponent,
    data: { title: 'Professor Add' }
  },
  {
    path: 'professor-update/:idUpdate',
    component: ProfessorFormComponent,
    data: { title: 'Professor Update' }
  },
  {
    path: 'professor-detail/:idDetail',
    component: ProfessorFormComponent,
    data: { title: 'Professor Details' }
  },
  {
    path: 'update-course/:courseId',
    component: UpdateCourseComponent,
    data: { title: 'Update Course' }
  },
  {
    path: 'list-course',
    component: ListCourseComponent,
    data: { title: 'List Course' }
  },
  {
    path: 'student-list/:action',
    component: StudentListComponent,
    data: { title: 'Student List' }
  },
  {
    path: 'student-add',
    component: StudentFormComponent,
    data: { title: 'Student Add' }
  },
  {
    path: 'student-update/:idUpdate',
    component: StudentFormComponent,
    data: { title: 'Student Update' }
  },
  {
    path: 'student-detail/:idDetail',
    component: StudentFormComponent,
    data: { title: 'Student Details' }
  }
];

@NgModule({
  declarations: [
    AppComponent,
    FormCourseComponent,
    ListCourseComponent,
    UpdateCourseComponent,
    FormCourseComponent,
    ProfessorListComponent,
    StudentListComponent,
    StudentFormComponent,
    ProfessorFormComponent,
    ListCourseComponent,
    UpdateCourseComponent
  ],
  imports: [
    RouterModule.forRoot(appRoutes),
    FormsModule,
    ReactiveFormsModule,
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    ButtonsModule,
    BrowserAnimationsModule,
    InputsModule,
    LabelModule,
    MenuModule//,

   // ConfirmationPopoverModule.forRoot({ confirmButtonType:'danger'}),
  ],
  exports: [
    FormCourseComponent,

    DropDownsModule,
    InputsModule,
    //DialogsModule

    DropDownsModule,
    DialogsModule,
    GridModule,
    MenuModule,
    FormCourseComponent,
    ListCourseComponent,
    UpdateCourseComponent,
    HttpClientModule,
    GridModule,
    DropDownsModule,
    InputsModule,
    DialogsModule,
    BrowserAnimationsModule,
    ButtonsModule,
    LabelModule,
    MenuModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
