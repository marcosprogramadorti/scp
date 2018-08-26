
import { BrowserModule } from '@angular/platform-browser';

import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';


import { PessoaModule } from './pessoa/pessoa.module';

import { MessageService } from 'primeng/api';
import { PessoaService } from './pessoa/pessoa.service';
import { ConfigComponent } from './config/config.component';



@NgModule({
  declarations: [
    AppComponent,
    ConfigComponent,
  ],
  imports: [
    BrowserModule,
    BrowserAnimationsModule,
    PessoaModule
  ],
  providers: [PessoaService, MessageService ],
  bootstrap: [AppComponent]
})
export class AppModule { }
