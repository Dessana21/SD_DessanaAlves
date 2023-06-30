import { NgModule } from '@angular/core';
import { ProdutoTabelaComponent } from './components/produto-tabela/produto-tabela.component';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [
   {
  path: 'produtotabela',
  component: ProdutoTabelaComponent
   }
  ];

@NgModule({
  declarations: [],
  imports: [
   RouterModule.forRoot(routes)
  ],
  exports:[RouterModule]
})
export class AppRoutingModule { }
