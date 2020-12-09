
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




