import React from 'react';

import { StoreProvider } from './components/StoreProvider';
import TodoForm from './components/TodoForm';
import TodoList from './components/TodoList';
import Todo from './components/Todo';

function App() {
  return (
		<div className="container">
				<h2>LISTAS TO-DO</h2>
				<Todo/>
		</div>
	)
}

export default App;
