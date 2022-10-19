import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { ListComponent } from './feed/list/list.component';
import { HttpClientModule } from '@angular/common/http';
import { PagingComponent } from './feed/paging/paging.component';

@NgModule({
  declarations: [
    AppComponent,
    ListComponent,
    PagingComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
