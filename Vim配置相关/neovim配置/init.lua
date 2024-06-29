--基础配置
require('basic')
--快捷键设置
require("keybindings")
--插件设置
require("plugins")
-- 主题设置
require("colorscheme")
-- 插件配置
require("plugin-config.nvim-tree")
require("plugin-config.bufferline")
require("plugin-config.lualine")
require("plugin-config.telescope")
require("plugin-config.dashboard")
require("plugin-config.project")
require("plugin-config.nvim-autopairs")

-- 内置LSP
require("lsp.setup")
require("lsp.cmp")
require("lsp.ui")
require("plugin-config.indent-blankline")
require("lsp.null-ls")
-- Windows 10 中将 Neovim 中的内容复制到系统剪贴板
require("fix-yank")
require("dap.vimspector")
