
		/*** NEW ACTIVITIES AND SENDING DATA ***/
Intent (Context packageContext, Class<?> cls);	// intent constructor for changing activitis
Intent putExtra (String name, boolean value);	// key-value pare for passing data between activitis
void startActivity(Intent intent);	// start another activity
void startActivityForResult(Intent intent, int requestCode);	// track what activity respond back
final void setResult(int resultCode, Intent data);	// call in child activity to send back data
Intent getIntent ();	// return the intent that started this activity
boolean getBooleanExtra(String name, boolean defaultValue);	// retrieve the value from the extra
/* INITIAL_ACTIVITY
2. call static method from calledActivity pass current context and value, get Intent instance
3. start new activity (startActivityForResult), pass Intent instance and request code (int const) for future tracking
7. @Override onActivityResult(requestCode, resultCode, Intent) for all callbacks from all Activities
	check if requestCode is correct and call static method from calledActivity, pass Intent as an agr, save result
8. use result in initialActivity

CALLED_ACTIVITY
1. create static method that receive initialActivity context and value as parameters
	init new Intent object, pass context and current calledActivity.this object
	put extra value (key const str - value argument)
	return new instance

4. as activity created call getIntent().get"Boolean"Extra, pass key-const-str and default value if failed, save result
5. prepare for answer back, create new Intent instance and save reference to it
	put extra values for returning back to initialActivity (key const str - value)
	call setResult method and pass RESULT_OK status and ref to new created Intent instance
	call static method for answer handling
6. create static method for answer handling that receive created Intent instance and return boolean
	return result of instance.get"Boolean"Extra(key-const-str, default value if failed)
*/


		/*** FRAGMENT INITIALIZATION ***/
/*
1. xml layout file should define appearance of the fragment 
2. fragment controller java class extends Fragment superClass
	2.0. an empty public constructor is required
	2.1. @Override onCreateView method
		2.1.1. create an instance of View object and call inflate method on passed LayoutInflater argument, pass
			xml fragment layout resourse ID, ViewGroup argument and boolean value of attachToRoot argument
		2.1.2. return View`s reference variable

3. manage fragment not dynamically via activity xml layout file
	3.1. create a fragment widget with id, 'class' attr should contain full fragment`s controller class name,
		'tools:layout' attr should contain fragment`s xml layout file

4. manage fragment dynamically via manager class and manager xml layout
	4.1. add FrameLayout widget with unique id in manager xml layout, fragment will be injected here
	4.2. create public static final String tag with uniqe fragment identifier
	4.3. create an instance of fragment controller class and save to the reference variable
	4.4. get FragmentManager by calling getSupportFragmentManager method and save it to the reference variable
		4.4.1. call chained methods on fragment manager beginTransaction().
			add(container ID where to inject fragment, fragment controller instance var, unique tag).commit()
		4.4.2. in order to remove fragment by clicking back button in native android menu, add to chained call
			.addToBackStack(null) method just before .add() method
	4.5. if fragment controller already exist in manager class but out of scope,
		create a reference variable of type Fragment and call getSupportFragmentManager method on it,
		chained call to findFragmentByTag method with uniqe tag name
*/
		

		/*** FRAGMENT RECEIVING DATA FROM MANAGER ***/
/*
1. fragment controller class should contain public static final String field as an unique identifier
2. manager class should call for empty constructor of Bundle object and save result in a reference variable
	2.1. call put'String'(unique str key, string object) method on 2. reference variable
3. create an instance of your fragment controller class and save ref to the reference variable
	3.1. call setArguments() method on frament`s controller ref var and pass ref var of type Bundle object
4. continue on from paragraph #4.4. in fragment init part
5. in fragment controller class create new var of type Bundle by calling getArguments() method
	5.1. retrieve string from Bundle object by calling getString(unique str key) on ref var from fifth paragraph
*/

		/*** FRAGMENT WITH FACTORY METHOD RECEIVING DATA FROM MANAGER ***/
/*
1. fragment controller should create public static method that receive 'str' arg and return an inctance of it self
	1.1. call for empty constructor of Bundle object and save result in a reference variable
	1.2. call put'String'(unique str key, argument) method on Bundle`s object reference variable
	1.3. create an instance of fragment controller and save to the reference variable
	1.4. call setArguments() on fragment`s controller ref var and pass Bundle`s ref var as an argument
	1.5. return fragment`s controller ref var
2. manager class should create a ref var of type fragment controller and call static method from it and passing str obj
*/
