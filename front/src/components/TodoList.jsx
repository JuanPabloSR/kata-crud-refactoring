import React,{useEffect,useContext} from 'react'
import Store from './StoreProvider';
import TodoForm from './TodoForm';
const HOST_API = "http://localhost:8080/api";


const TodoList =({ el,db,setDb}) => {
    const { id,name, listtodo } = el

    const {
      dispatch,
      state: { todo },
    } = useContext(Store)
    const currentList =todo.list.filter((e)=>e.listtodo===el.id)
    //todo.list
    
    console.log("todo",todo)
    console.log("list",listtodo)
    console.log("el",el)

    useEffect(() => {
      fetch(HOST_API + '/todos')
        .then((response) => response.json())
        .then((list) => {
          dispatch({ type: 'update-list', list })
        })
    }, [dispatch])
  
    const onDelete = (id) => {
      fetch(HOST_API + '/' + id + '/todo', {
        method: 'DELETE',
      }).then((list) => {
        dispatch({ type: 'delete-item', id })
      })
    }
  
    const onEdit = (todo) => {
      dispatch({ type: 'edit-item', item: todo })
    }
  
    const onChange = (event, todo) => {
      const request = {
        name: todo.name,
        id: todo.id,
        completed: event.target.checked,
        listtodo:id

      }
      fetch(HOST_API + '/todo', {
        method: 'PUT',
        body: JSON.stringify(request),
        headers: {
          'Content-Type': 'application/json',
        },
      })
        .then((response) => response.json())
        .then((todo) => {
          dispatch({ type: 'update-item', item: todo })
        })
    }
  
    
    const decorationDone = {
      textDecoration: 'line-through'
    };

    async function deleteData(idData) {
        const response = await fetch(HOST_API +'/'+idData+ '/list/', {
            method: 'DELETE',
            headers: {'Content-Type': 'application/json'},
        });
        const dbFiltered=db.filter((el)=>el.id!==idData)
        setDb(dbFiltered)
        
    }
    return (
        <div>
        <fieldset className="made-up">
        <legend >
                    <label>{name}</label>
					<button
                    onClick={()=>deleteData(id)}
                    >Eliminar</button>
				</legend>
				<TodoForm idlist={id} el={el}/>
        <table>
          <thead>
            <tr>
              <td>ID</td>
              <td>Tarea</td>
              <td>¿Completado?</td>
            </tr>
          </thead>
          <tbody>
            {currentList.map((todo) => {
              return (
                <tr key={todo.id} style={todo.completed ? decorationDone : {}}>
                  <td>{todo.id}</td>
                  <td>{todo.name}</td>
                  <td>
                    <input
                      type='checkbox'
                      defaultChecked={todo.completed}
                      onChange={(event) => onChange(event, todo)}
                    ></input>
                  </td>
                  <td>
                    <button onClick={() => onDelete(todo.id)}>Eliminar</button>
                  </td>
                  <td>
                    <button onClick={() => onEdit(todo)}>Editar</button>
                  </td>
                </tr>
              )
            })}
          </tbody>
        </table>
      </fieldset>
    </div>
    )
}

export default TodoList