package info.izumin.android.droidux.processor.fixture;

/**
 * Created by izumin on 11/2/15.
 */
public final class Source {
    public static final String TAG = Source.class.getSimpleName();

    public static final String[] EMPTY = {};

    public static class Counter {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "@Reducer(Counter.class)",
                "public class CounterReducer {",
                "    @Dispatchable(IncrementCountAction.class)",
                "    public Counter onIncrement(Counter state, IncrementCountAction action) {",
                "        return state;",
                "    }",
                "}"
        };

        public static final String[] GENERATED = {
                "package info.izumin.android.droidux.sample;",
                "",
                "import info.izumin.android.droidux.Action;",
                "import info.izumin.android.droidux.Middleware;",
                "import info.izumin.android.droidux.Store;",
                "import info.izumin.android.droidux.exception.NotInitializedException;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "",
                "public final class DroiduxCounterStore extends Store<Counter> {",
                "    private final CounterReducer counterReducer;",
                "",
                "    protected DroiduxCounterStore(Builder builder) {",
                "        super(builder);",
                "        this.counterReducer = builder.counterReducer;",
                "        setState(builder.counter);",
                "    }",
                "",
                "    @Override",
                "    protected void dispatchToReducer(Action action) {",
                "        Class<? extends Action> actionClass = action.getClass();",
                "        Counter result = null;",
                "        if (IncrementCountAction.class.isAssignableFrom(actionClass)) {",
                "            result = counterReducer.onIncrement(getState(), (IncrementCountAction) action);",
                "        }",
                "        if (result != null) {",
                "            setState(result);",
                "        }",
                "    }",
                "",
                "    public static class Builder extends info.izumin.android.droidux.Store.Builder {",
                "        private CounterReducer counterReducer;",
                "        private Counter counter;",
                "",
                "        public Builder() {",
                "            super();",
                "        }",
                "",
                "        @Override",
                "        public Builder addMiddleware(Middleware middleware) {",
                "            super.addMiddleware(middleware);",
                "            return this;",
                "        }",
                "",
                "        public Builder setReducer(CounterReducer counterReducer) {",
                "            this.counterReducer = counterReducer;",
                "            return this;",
                "        }",
                "",
                "        public Builder setInitialState(Counter counter) {",
                "            this.counter = counter;",
                "            return this;",
                "        }",
                "",
                "        @Override",
                "        public DroiduxCounterStore build() {",
                "            if (counterReducer == null) {",
                "                throw new NotInitializedException(\"CounterReducer has not been initialized.\");",
                "            }",
                "            if (counter == null) {",
                "                throw new NotInitializedException(\"Counter has not been initialized.\");",
                "            }",
                "            return new DroiduxCounterStore(this);",
                "        }",
                "    }",
                "}"
        };
    }

    public static class CounterTakesOnlyStateArgument {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "@Reducer(Counter.class)",
                "public class CounterReducer {",
                "    @Dispatchable(IncrementCountAction.class)",
                "    public Counter onIncrement(Counter state) {",
                "        return state;",
                "    }",
                "}"
        };

        public static final String[] GENERATED = {
                "package info.izumin.android.droidux.sample;",
                "",
                "import info.izumin.android.droidux.Action;",
                "import info.izumin.android.droidux.Middleware;",
                "import info.izumin.android.droidux.Store;",
                "import info.izumin.android.droidux.exception.NotInitializedException;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "",
                "public final class DroiduxCounterStore extends Store<Counter> {",
                "    private final CounterReducer counterReducer;",
                "",
                "    protected DroiduxCounterStore(Builder builder) {",
                "        super(builder);",
                "        this.counterReducer = builder.counterReducer;",
                "        setState(builder.counter);",
                "    }",
                "",
                "    @Override",
                "    protected void dispatchToReducer(Action action) {",
                "        Class<? extends Action> actionClass = action.getClass();",
                "        Counter result = null;",
                "        if (IncrementCountAction.class.isAssignableFrom(actionClass)) {",
                "            result = counterReducer.onIncrement(getState());",
                "        }",
                "        if (result != null) {",
                "            setState(result);",
                "        }",
                "    }",
                "",
                "    public static class Builder extends info.izumin.android.droidux.Store.Builder {",
                "        private CounterReducer counterReducer;",
                "        private Counter counter;",
                "",
                "        public Builder() {",
                "            super();",
                "        }",
                "",
                "        @Override",
                "        public Builder addMiddleware(Middleware middleware) {",
                "            super.addMiddleware(middleware);",
                "            return this;",
                "        }",
                "",
                "        public Builder setReducer(CounterReducer counterReducer) {",
                "            this.counterReducer = counterReducer;",
                "            return this;",
                "        }",
                "",
                "        public Builder setInitialState(Counter counter) {",
                "            this.counter = counter;",
                "            return this;",
                "        }",
                "",
                "        @Override",
                "        public DroiduxCounterStore build() {",
                "            if (counterReducer == null) {",
                "                throw new NotInitializedException(\"CounterReducer has not been initialized.\");",
                "            }",
                "            if (counter == null) {",
                "                throw new NotInitializedException(\"Counter has not been initialized.\");",
                "            }",
                "            return new DroiduxCounterStore(this);",
                "        }",
                "    }",
                "}"
        };
    }

    public static class TodoList {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.processor.fixture.AddTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.CompleteTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.TodoList;",
                "@Reducer(TodoList.class)",
                "public class TodoListReducer {",
                "    @Dispatchable(AddTodoItemAction.class)",
                "    public TodoList onAddItem(TodoList state, AddTodoItemAction action) {",
                "        return state;",
                "    }",
                "    @Dispatchable(CompleteTodoItemAction.class)",
                "    public TodoList onCompleteItem(TodoList state, CompleteTodoItemAction action) {",
                "        return state;",
                "    }",
                "}"
        };

        public static final String[] GENERATED = {
                "package info.izumin.android.droidux.sample;",
                "",
                "import info.izumin.android.droidux.Action;",
                "import info.izumin.android.droidux.Middleware;",
                "import info.izumin.android.droidux.Store;",
                "import info.izumin.android.droidux.exception.NotInitializedException;",
                "import info.izumin.android.droidux.processor.fixture.AddTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.CompleteTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.TodoList;",
                "",
                "public final class DroiduxTodoListStore extends Store<TodoList> {",
                "    private final TodoListReducer todoListReducer;",
                "",
                "    protected DroiduxTodoListStore(Builder builder) {",
                "        super(builder);",
                "        this.todoListReducer = builder.todoListReducer;",
                "        setState(builder.todoList);",
                "    }",
                "",
                "    @Override",
                "    protected void dispatchToReducer(Action action) {",
                "        Class<? extends Action> actionClass = action.getClass();",
                "        TodoList result = null;",
                "        if (AddTodoItemAction.class.isAssignableFrom(actionClass)) {",
                "            result = todoListReducer.onAddItem(getState(), (AddTodoItemAction) action);",
                "        }",
                "        if (CompleteTodoItemAction.class.isAssignableFrom(actionClass)) {",
                "            result = todoListReducer.onCompleteItem(getState(), (CompleteTodoItemAction) action);",
                "        }",
                "        if (result != null) {",
                "            setState(result);",
                "        }",
                "    }",
                "",
                "    public static class Builder extends info.izumin.android.droidux.Store.Builder {",
                "        private TodoListReducer todoListReducer;",
                "        private TodoList todoList;",
                "",
                "        public Builder() {",
                "            super();",
                "        }",
                "",
                "        @Override",
                "        public Builder addMiddleware(Middleware middleware) {",
                "            super.addMiddleware(middleware);",
                "            return this;",
                "        }",
                "",
                "        public Builder setReducer(TodoListReducer todoListReducer) {",
                "            this.todoListReducer = todoListReducer;",
                "            return this;",
                "        }",
                "",
                "        public Builder setInitialState(TodoList todoList) {",
                "            this.todoList = todoList;",
                "            return this;",
                "        }",
                "",
                "        @Override",
                "        public DroiduxTodoListStore build() {",
                "            if (todoListReducer == null) {",
                "                throw new NotInitializedException(\"TodoListReducer has not been initialized.\");",
                "            }",
                "            if (todoList == null) {",
                "                throw new NotInitializedException(\"TodoList has not been initialized.\");",
                "            }",
                "            return new DroiduxTodoListStore(this);",
                "        }",
                "    }",
                "}"
        };
    }

    public static class CombinedTwoReducers {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.processor.fixture;",
                "import info.izumin.android.droidux.annotation.CombinedReducer;",
                "@CombinedReducer({CounterReducer.class, TodoListReducer.class})",
                "public class RootReducer {",
                "}"
        };

        public static final String[] GENERATED = {
                "package info.izumin.android.droidux.processor.fixture;",
                "",
                "import info.izumin.android.droidux.CombinedStore;",
                "import info.izumin.android.droidux.Middleware;",
                "import info.izumin.android.droidux.exception.NotInitializedException;",
                "",
                "public final class DroiduxRootStore extends CombinedStore {",
                "    private final CounterReducer counterReducer;",
                "    private final DroiduxCounterStore counterStore;",
                "    private final TodoListReducer todoListReducer;",
                "    private final DroiduxTodoListStore todoListStore;",
                "",
                "    protected DroiduxRootStore(Builder builder) {",
                "        super(builder);",
                "        this.counterReducer = builder.counterReducer;",
                "        this.counterStore = new DroiduxCounterStore.Builder().setReducer(counterReducer).setInitialState(builder.counter).build();",
                "        addStore(counterStore);",
                "        this.todoListReducer = builder.todoListReducer;",
                "        this.todoListStore = new DroiduxTodoListStore.Builder().setReducer(todoListReducer).setInitialState(builder.todoList).build();",
                "        addStore(todoListStore);",
                "    }",
                "",
                "    public DroiduxCounterStore getCounterStore() {",
                "        return counterStore;",
                "    }",
                "",
                "    public DroiduxTodoListStore getTodoListStore() {",
                "        return todoListStore;",
                "    }",
                "",
                "    public static class Builder extends info.izumin.android.droidux.Store.Builder {",
                "        private CounterReducer counterReducer;",
                "        private Counter counter;",
                "        private TodoListReducer todoListReducer;",
                "        private TodoList todoList;",
                "",
                "        public Builder() {",
                "            super();",
                "        }",
                "",
                "        @Override",
                "        public Builder addMiddleware(Middleware middleware) {",
                "            super.addMiddleware(middleware);",
                "            return this;",
                "        }",
                "",
                "        public Builder setReducer(CounterReducer counterReducer) {",
                "            this.counterReducer = counterReducer;",
                "            return this;",
                "        }",
                "",
                "        public Builder setInitialState(Counter counter) {",
                "            this.counter = counter;",
                "            return this;",
                "        }",
                "",
                "        public Builder setReducer(TodoListReducer todoListReducer) {",
                "            this.todoListReducer = todoListReducer;",
                "            return this;",
                "        }",
                "",
                "        public Builder setInitialState(TodoList todoList) {",
                "            this.todoList = todoList;",
                "            return this;",
                "        }",
                "",
                "        @Override",
                "        public DroiduxRootStore build() {",
                "            if (counterReducer == null) {",
                "                throw new NotInitializedException(\"CounterReducer has not been initialized.\");",
                "            }",
                "            if (counter == null) {",
                "                throw new NotInitializedException(\"Counter has not been initialized.\");",
                "            }",
                "            if (todoListReducer == null) {",
                "                throw new NotInitializedException(\"TodoListReducer has not been initialized.\");",
                "            }",
                "            if (todoList == null) {",
                "                throw new NotInitializedException(\"TodoList has not been initialized.\");",
                "            }",
                "            return new DroiduxRootStore(this);",
                "        }",
                "    }",
                "}"
        };
    }

    public static class UndoableTodoList {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.annotation.Undoable;",
                "import info.izumin.android.droidux.processor.fixture.AddTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.CompleteTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.TodoList;",
                "@Undoable",
                "@Reducer(TodoList.class)",
                "public class UndoableTodoListReducer {",
                "    @Dispatchable(AddTodoItemAction.class)",
                "    public TodoList onAddItem(TodoList state, AddTodoItemAction action) {",
                "        return state;",
                "    }",
                "    @Dispatchable(CompleteTodoItemAction.class)",
                "    public TodoList onCompleteItem(TodoList state, CompleteTodoItemAction action) {",
                "        return state;",
                "    }",
                "}"
        };

        public static final String[] GENERATED = {
                "package info.izumin.android.droidux.sample;",
                "",
                "import info.izumin.android.droidux.Action;",
                "import info.izumin.android.droidux.Middleware;",
                "import info.izumin.android.droidux.UndoableStore;",
                "import info.izumin.android.droidux.exception.NotInitializedException;",
                "import info.izumin.android.droidux.processor.fixture.AddTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.CompleteTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.TodoList;",
                "",
                "public final class DroiduxUndoableTodoListStore extends UndoableStore<TodoList> {",
                "    private final UndoableTodoListReducer undoableTodoListReducer;",
                "",
                "    protected DroiduxTodoListStore(Builder builder) {",
                "        super(builder, builder.todoList);",
                "        this.undoableTodoListReducer = builder.undoableTodoListReducer;",
                "    }",
                "",
                "    @Override",
                "    protected void dispatchToReducer(Action action) {",
                "        super.dispatchToReducer(action);",
                "        Class<? extends Action> actionClass = action.getClass();",
                "        TodoList result = null;",
                "        if (AddTodoItemAction.class.isAssignableFrom(actionClass)) {",
                "            result = undoableTodoListReducer.onAddItem(getState().clone(), (AddTodoItemAction) action);",
                "        }",
                "        if (CompleteTodoItemAction.class.isAssignableFrom(actionClass)) {",
                "            result = undoableTodoListReducer.onCompleteItem(getState().clone(), (CompleteTodoItemAction) action);",
                "        }",
                "        if (result != null) {",
                "            setState(result);",
                "        }",
                "    }",
                "",
                "    public static class Builder extends info.izumin.android.droidux.Store.Builder {",
                "        private UndoableTodoListReducer undoableTodoListReducer;",
                "        private TodoList todoList;",
                "",
                "        public Builder() {",
                "            super();",
                "        }",
                "",
                "        @Override",
                "        public Builder addMiddleware(Middleware middleware) {",
                "            super.addMiddleware(middleware);",
                "            return this;",
                "        }",
                "",
                "        public Builder setReducer(UndoableTodoListReducer undoableTodoListReducer) {",
                "            this.undoableTodoListReducer = undoableTodoListReducer;",
                "            return this;",
                "        }",
                "",
                "        public Builder setInitialState(TodoList todoList) {",
                "            this.todoList = todoList;",
                "            return this;",
                "        }",
                "",
                "        @Override",
                "        public DroiduxUndoableTodoListStore build() {",
                "            if (undoableTodoListReducer == null) {",
                "                throw new NotInitializedException(\"UndoableTodoListReducer has not been initialized.\");",
                "            }",
                "            if (todoList == null) {",
                "                throw new NotInitializedException(\"TodoList has not been initialized.\");",
                "            }",
                "            return new DroiduxUndoableTodoListStore(this);",
                "        }",
                "    }",
                "}"
        };
    }

    public static class DispatchableTakesWrongStateType {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "@Reducer(Counter.class)",
                "public class CounterReducer {",
                "    @Dispatchable(IncrementCountAction.class)",
                "    public Counter onIncrement(Object state, IncrementCountAction action) {",
                "        return state;",
                "    }",
                "}"
        };
    }

    public static class DispatchableTakesWrongActionType {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.processor.fixture.AddTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.CompleteTodoItemAction;",
                "import info.izumin.android.droidux.processor.fixture.TodoList;",
                "@Reducer(TodoList.class)",
                "public class TodoListReducer {",
                "    @Dispatchable(AddTodoItemAction.class)",
                "    public TodoList onAddItem(TodoList state, CompleteTodoItemAction action) {",
                "        return state;",
                "    }",
                "}"
        };
    }

    public static class DispatchableTakesNoArguments {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "@Reducer(Counter.class)",
                "public class CounterReducer {",
                "    @Dispatchable(IncrementCountAction.class)",
                "    public Counter onIncrement() {",
                "        return state;",
                "    }",
                "}"
        };
    }

    public static class DispatchableTakesExtraArguments {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "@Reducer(Counter.class)",
                "public class CounterReducer {",
                "    @Dispatchable(IncrementCountAction.class)",
                "    public Counter onIncrement(Counter state, IncrementCountAction action, String extra) {",
                "        return state;",
                "    }",
                "}"
        };
    }

    public static class ReducerWithoutSuffix {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "@Reducer(Counter.class)",
                "public class CounterReduce {",
                "    @Dispatchable(IncrementCountAction.class)",
                "    public Counter onIncrement(Counter state, IncrementCountAction action, String extra) {",
                "        return state;",
                "    }",
                "}"
        };
    }

    public static class UndoableReducerWithoutUndoableState {
        public static final String[] TARGET = {
                "package info.izumin.android.droidux.sample;",
                "import info.izumin.android.droidux.annotation.Dispatchable;",
                "import info.izumin.android.droidux.annotation.Reducer;",
                "import info.izumin.android.droidux.annotation.Undoable;",
                "import info.izumin.android.droidux.processor.fixture.IncrementCountAction;",
                "import info.izumin.android.droidux.processor.fixture.Counter;",
                "@Undoable",
                "@Reducer(Counter.class)",
                "public class CounterReduce {",
                "    @Dispatchable(IncrementCountAction.class)",
                "    public Counter onIncrement(Counter state, IncrementCountAction action, String extra) {",
                "        return state;",
                "    }",
                "}"
        };
    }
}
