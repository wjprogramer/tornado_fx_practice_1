
## MVC

1. Model - The business code layer that holds core logic and data
1. View - The visual display with various input and output controls
1. Controller - The "middleman" mediating events between the Model and the View

## Fragment

Both `View` and `Fragment` support `openModal()`, `openWindow()`, and `openInternalWindow()` functions that will open the root node in a separate Window.

## Optional Arguments for openModal()

| Argument | 	Type | 	Description |
| :---- | :---- | :---- |
| stageStyle | 	StageStyle | 	Defines one of the possible enum styles for `Stage`. Default: `StageStyle.DECORATED` |
| modality | 	Modality | 	Defines one of the possible enum modality types for `Stage`. Default: `Modality.APPLICATION_MODAL` |
| escapeClosesWindow | 	Boolean | 	Sets the `ESC` key to call `close()`. Default: `true` |
| owner | 	Window | 	Specify the owner Window for this Stage |
| block | 	Boolean | 	Block UI execution until the Window closes. Default: `false` |

## openInternalWindow

While `openModal` opens in a new Stage, 
`openInternalWindow` opens over the current root node, 
or any other node if you specify it

class `InternalWindow.Styles`

### Optional Arguments for openInternalWindow()

|a|b|c|
|:--|:--|:--|
|||

---

| Argument | Type | Description |
| :---- | :---- | :---- |
| view | 	UIComponent | 	The component will be the content of the new window |
| view | 	KClass | 	Alternatively, you can supply the class of the view instead of an instance |
| icon | 	Node | 	Optional window icon |
| scope | 	Scope | 	If you specify the view class, you can also specify the scope used to fetch the view |
| modal | 	Boolean | 	Defines if the covering node should be disabled while the internal window is active. Default: `true` |
| escapeClosesWindow | 	Boolean | 	Sets the ESC key to call close(). Default: `true` |
| owner | 	Node | 	Specify the owner Node for this window. The window will by default cover the root node of this view. |
| closeButton | 	Boolean | 	Whether there is the close button in window. Default: `true` |
| movable | 	Boolean | 	Whether the window is movable. Default: `true` |
| overlayPaint | 	Paint | 	The paint for overlay part of internal window over window. Default: `c("#000", 0.4)` |

### Closing Modal Windows

Any Component opened using `openModal()`, `openWindow()` or `openInternalWindow()` can be closed by calling `close()`. It is also possible to get to the `InternalWindow` instance directly if needed using `findParentOfType(InternalWindow::class)`.




