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
import { ConfirmationPopoverModule } from 'angular-confirmation-popover';
import { NewsListComponent } from './components/news-list/news-list.component';
import { NewsFormComponent } from './components/news-form/news-form.component';
import { CommentNewsListComponent } from './components/comment-news-list/comment-news-list.component';
import { CommentNewsFormComponent } from './components/comment-news-form/comment-news-form.component';





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
  
  }, {
    path: 'news-list',
    component: NewsListComponent,
    data: { title: 'News List' }
  },
  {
    path: 'news-add',
    component: NewsFormComponent,
    data: { title: 'News Add' }
  },
  {
    path: 'news-update/:idUpdate',
    component: NewsFormComponent,
    data: { title: 'News Update' }
  },
  {
    path: 'news-detail/:idDetail',
    component: NewsFormComponent,
    data: { title: 'News Details' }
  },
  {
    path: 'comment-news-list',
    component: CommentNewsListComponent,
    data: { title: 'Comment List' }
  },
  {
    path: 'comment-news-add',
    component: CommentNewsFormComponent,
    data: { title: 'Comment Add' }
  },
  {
    path: 'comment-news-update/:idUpdate',
    component: CommentNewsFormComponent,
    data: { title: 'Comment Update' }
  },
  {
    path: 'comment-news-detail/:idDetail',
    component: CommentNewsFormComponent,
    data: { title: 'Comment Details' }
  },

];

@NgModule({
  declarations: [
    AppComponent,
    //  CourseComponent,
    FormCourseComponent,
    ListCourseComponent,
    UpdateCourseComponent,
    FormCourseComponent,
    ProfessorListComponent,
    StudentListComponent,
    StudentFormComponent,
    ProfessorFormComponent,
    ListCourseComponent,
    UpdateCourseComponent,
    NewsListComponent,
    NewsFormComponent,
    CommentNewsListComponent,
    CommentNewsFormComponent,
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
    MenuModule,
    ConfirmationPopoverModule.forRoot({ confirmButtonType:'danger'
  })
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
